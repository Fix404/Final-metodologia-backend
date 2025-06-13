package org.example.final_metodologia_backend.controllers;

import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.preference.*;
import com.mercadopago.resources.preference.Preference;
import lombok.RequiredArgsConstructor;
import org.example.final_metodologia_backend.dto.CarritoItemDto;
import org.example.final_metodologia_backend.entities.Detalle;
import org.example.final_metodologia_backend.entities.OrdenCompra;
import org.example.final_metodologia_backend.entities.ProductoCantidad;
import org.example.final_metodologia_backend.services.OrdenCompraService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pay")
@RequiredArgsConstructor
public class MercadoPagoController {
    private final OrdenCompraService ordenCompraService;

    @Value("${mercadopago.access-token}")
    private String mercadoPagoAccessToken;

    @PostMapping("/mp")
    @CrossOrigin("*")
    public ResponseEntity<Map<String, String>> mp(@RequestBody Map<String, Object> body) throws Exception {

        if (body.get("usuarioId") == null || body.get("carrito") == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Datos inválidos: usuarioId y carrito son requeridos."));
        }

        Long usuarioId = Long.valueOf(body.get("usuarioId").toString());
        List<Map<String, Object>> carritoData = (List<Map<String, Object>>) body.get("carrito");

        List<CarritoItemDto> carrito = new ArrayList<>();

        // ✅ Ajustamos la lectura del carrito para coincidir con la estructura del frontend
        for (Map<String, Object> item : carritoData) {
            if (!item.containsKey("detalle") || !item.containsKey("cantidad")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(Map.of("error", "Cada ítem del carrito debe contener `detalle` y `cantidad`."));
            }

            Map<String, Object> detalle = (Map<String, Object>) item.get("detalle");
            if (!detalle.containsKey("id")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(Map.of("error", "El objeto `detalle` debe contener `id`."));
            }

            CarritoItemDto carritoItem = new CarritoItemDto();
            carritoItem.setDetalleId(Long.valueOf(detalle.get("id").toString())); // ✅ Extraer `id` correctamente
            carritoItem.setCantidad(Integer.parseInt(item.get("cantidad").toString()));
            carrito.add(carritoItem);
        }

        System.out.println("Token de MercadoPago utilizado: " + mercadoPagoAccessToken);
        MercadoPagoConfig.setAccessToken(mercadoPagoAccessToken);

        System.out.println("Solicitud recibida en /pay/mp");

        List<PreferenceItemRequest> items = new ArrayList<>();

        OrdenCompra ordenCompra = ordenCompraService.generarOrdenCompra(carrito, usuarioId);

        for (ProductoCantidad productoCantidad : ordenCompra.getProductoCantidad()) {
            Detalle detalle = productoCantidad.getDetalle();
            int cantidad = productoCantidad.getCantidad();
            Double precioUnitario = detalle.getPrecio().getPrecioVenta();

            PreferenceItemRequest item = PreferenceItemRequest.builder()
                    .id(detalle.getId().toString())
                    .title(detalle.getProducto().getNombre())
                    .description(detalle.getProducto().getDescripcion())
                    .quantity(cantidad)
                    .currencyId("ARS")
                    .unitPrice(BigDecimal.valueOf(precioUnitario))
                    .build();
            items.add(item);
        }

        PreferenceBackUrlsRequest backUrls = PreferenceBackUrlsRequest.builder()
                .success("https://localhost:5173/paymentSuccess")
                .pending("https://localhost:5173/")
                .failure("https://localhost:5173/paymentFailure")
                .build();

        List<PreferencePaymentTypeRequest> excludedPaymentTypes = new ArrayList<>();
        excludedPaymentTypes.add(PreferencePaymentTypeRequest.builder().id("ticket").build());

        PreferencePaymentMethodsRequest paymentMethods = PreferencePaymentMethodsRequest.builder()
                .excludedPaymentTypes(excludedPaymentTypes)
                .installments(1)
                .build();

        PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                .items(items)
                .backUrls(backUrls)
                .paymentMethods(paymentMethods)
                .autoReturn("approved")
                .build();

        PreferenceClient client = new PreferenceClient();
        Preference preference = client.create(preferenceRequest);

        System.out.println("URL de pago: " + preference.getInitPoint());

        return ResponseEntity.ok().body(Map.of("urlPago", preference.getInitPoint()));
    }
}
