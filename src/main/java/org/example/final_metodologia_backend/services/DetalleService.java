package org.example.final_metodologia_backend.services;

import org.example.final_metodologia_backend.dto.CreateDetalleDto;
import org.example.final_metodologia_backend.dto.DetalleDto;
import org.example.final_metodologia_backend.entities.*;
import org.example.final_metodologia_backend.repositories.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetalleService extends BaseService<Detalle, Long> {

    private final DetalleRepository detalleRepository;
    private final ProductoRepository productoRepository;
    private final PrecioRepository precioRepository;
    private final ColorRepository colorRepository;
    private final TalleRepository talleRepository;

    public DetalleService(DetalleRepository detalleRepository,
                          ProductoRepository productoRepository,
                          PrecioRepository precioRepository,
                          ColorRepository colorRepository,
                          TalleRepository talleRepository) {
        super(detalleRepository);
        this.detalleRepository = detalleRepository;
        this.productoRepository = productoRepository;
        this.precioRepository = precioRepository;
        this.colorRepository = colorRepository;
        this.talleRepository = talleRepository;
    }


    public List<Detalle> obtenerDetallesPorProductoId(Long productoId) {
        return detalleRepository.findByProductoId(productoId);
    }

    public DetalleDto mapToDTO(Detalle detalle) {
        return new DetalleDto(
                detalle.getId(),
                detalle.getStock(),
                detalle.getEstado(),
                detalle.getTalle() != null ? detalle.getTalle().getTalle() : null,
                detalle.getColor() != null ? detalle.getColor().getColor() : null,
                detalle.getPrecio() != null ? detalle.getPrecio().getPrecioVenta() : null,
                detalle.getProducto() != null ? detalle.getProducto().getNombre() : null
        );
    }

    public List<DetalleDto> listarDetallesDTO() throws Exception {
        List<Detalle> detalles = this.listar();
        return detalles.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public DetalleDto crearDetalle(CreateDetalleDto detalleDto) throws Exception {
        Detalle detalle = new Detalle();

        // Buscar las entidades relacionadas por sus IDs
        Producto producto = productoRepository.findById(detalleDto.getProductoId())
                .orElseThrow(() -> new Exception("Producto no encontrado"));
        Precio precio = precioRepository.findById(detalleDto.getPrecioId())
                .orElseThrow(() -> new Exception("Precio no encontrado"));
        Color color = colorRepository.findById(detalleDto.getColorId())
                .orElseThrow(() -> new Exception("Color no encontrado"));
        Talle talle = talleRepository.findById(detalleDto.getTalleId())
                .orElseThrow(() -> new Exception("Talle no encontrado"));

        // Asignar valores a la entidad Detalle
        detalle.setProducto(producto);
        detalle.setPrecio(precio);
        detalle.setColor(color);
        detalle.setTalle(talle);
        detalle.setStock(detalleDto.getStock());
        detalle.setEstado(detalleDto.getEstado());

        // Guardar entidad
        detalle = detalleRepository.save(detalle);

        // Convertir la entidad guardada a DTO para devolver
        return mapToDTO(detalle);
    }

    public DetalleDto actualizarDetalle(Long id, CreateDetalleDto detalleDto) throws Exception {
        Detalle detalleExistente = detalleRepository.findById(id)
                .orElseThrow(() -> new Exception("Detalle no encontrado"));

        Producto producto = productoRepository.findById(detalleDto.getProductoId())
                .orElseThrow(() -> new Exception("Producto no encontrado"));
        Precio precio = precioRepository.findById(detalleDto.getPrecioId())
                .orElseThrow(() -> new Exception("Precio no encontrado"));
        Color color = colorRepository.findById(detalleDto.getColorId())
                .orElseThrow(() -> new Exception("Color no encontrado"));
        Talle talle = talleRepository.findById(detalleDto.getTalleId())
                .orElseThrow(() -> new Exception("Talle no encontrado"));

        detalleExistente.setProducto(producto);
        detalleExistente.setPrecio(precio);
        detalleExistente.setColor(color);
        detalleExistente.setTalle(talle);
        detalleExistente.setStock(detalleDto.getStock());
        detalleExistente.setEstado(detalleDto.getEstado());

        detalleExistente = detalleRepository.save(detalleExistente);

        return mapToDTO(detalleExistente);
    }




}

