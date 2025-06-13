package org.example.final_metodologia_backend.services;

import org.example.final_metodologia_backend.dto.CarritoItemDto;
import org.example.final_metodologia_backend.entities.Detalle;
import org.example.final_metodologia_backend.entities.OrdenCompra;
import org.example.final_metodologia_backend.entities.ProductoCantidad;
import org.example.final_metodologia_backend.entities.Usuario;
import org.example.final_metodologia_backend.entities.enums.Movimiento;
import org.example.final_metodologia_backend.repositories.DetalleRepository;
import org.example.final_metodologia_backend.repositories.OrdenCompraRepository;
import org.example.final_metodologia_backend.repositories.ProductoCantidadRepository;
import org.example.final_metodologia_backend.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class OrdenCompraService extends BaseService<OrdenCompra, Long> {
    private final OrdenCompraRepository ordenCompraRepository;
    private final UsuarioRepository usuarioRepository;
    private final DetalleRepository detalleRepository;
    private final ProductoCantidadRepository productoCantidadRepository;
    private static final Logger logger = Logger.getLogger(OrdenCompraService.class.getName());

    public OrdenCompraService(OrdenCompraRepository ordenCompraRepository,
                              UsuarioRepository usuarioRepository,
                              DetalleRepository detalleRepository,
                              ProductoCantidadRepository productoCantidadRepository) {
        super(ordenCompraRepository);
        this.ordenCompraRepository = ordenCompraRepository;
        this.usuarioRepository = usuarioRepository;
        this.detalleRepository = detalleRepository;
        this.productoCantidadRepository = productoCantidadRepository;
    }

    @Transactional
    public OrdenCompra generarOrdenCompra(List<CarritoItemDto> carrito, Long usuarioId) throws Exception {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new Exception("Usuario no encontrado"));

        float precioTotal = 0f;
        List<ProductoCantidad> productosCantidad = new ArrayList<>();

        for (CarritoItemDto item : carrito) {
            Detalle detalle = detalleRepository.findById(item.getDetalleId())
                    .orElseThrow(() -> new Exception("Detalle no encontrado"));

            // 🔹 **Verificar si el producto ya existe antes de insertarlo**
            Optional<ProductoCantidad> existente = productoCantidadRepository.findByDetalleAndCantidad(detalle, item.getCantidad());
            ProductoCantidad productoCantidad;

            if (existente.isPresent()) {
                productoCantidad = existente.get();
                logger.info(" ProductoCantidad ya existe, usando el existente: " + productoCantidad.getId());
            } else {
                productoCantidad = new ProductoCantidad();
                productoCantidad.setDetalle(detalle);
                productoCantidad.setCantidad(item.getCantidad());
                productoCantidad = productoCantidadRepository.save(productoCantidad);
                logger.info(" ProductoCantidad creado exitosamente con ID: " + productoCantidad.getId());
            }

            // 🔹 **Validar que el precio no sea `null` antes de calcular el total**
            Double precioUnitario = detalle.getPrecio().getPrecioVenta();
            if (precioUnitario == null) throw new Exception("❌ Detalle sin precio de venta: " + detalle.getId());

            precioTotal += precioUnitario * item.getCantidad();
            productosCantidad.add(productoCantidad);
        }

        OrdenCompra orden = new OrdenCompra();
        orden.setUsuario(usuario);
        orden.setFecha(new Date());
        orden.setMovimiento(Movimiento.ENVIO);
        orden.setProductoCantidad(productosCantidad);
        orden.setPrecioTotal(precioTotal);

        OrdenCompra ordenGuardada = ordenCompraRepository.save(orden);
        logger.info(" Orden de compra creada exitosamente con ID: " + ordenGuardada.getId());

        return ordenGuardada;
    }
}
