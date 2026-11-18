
package com.parkmanager.controller;

import com.parkmanager.dto.DescuentoRequest;
import com.parkmanager.dto.DescuentoResponse;
import com.parkmanager.service.DescuentoService;
import com.parkmanager.model.TipoBoleto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/descuentos")
public class DescuentoController {

    private final DescuentoService descuentoService;

    public DescuentoController(DescuentoService descuentoService) {
        this.descuentoService = descuentoService;
    }

    @PutMapping("/{tipo}")
    public ResponseEntity<DescuentoResponse> establecerDescuento(
            @PathVariable TipoBoleto tipo,
            @RequestBody DescuentoRequest solicitud) {

        descuentoService.establecerDescuento(
                tipo, solicitud.getPorcentaje());

        DescuentoResponse respuesta = new DescuentoResponse(
                tipo,
                solicitud.getPorcentaje(),
                "Descuento configurado"
        );

        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{tipo}")
    public ResponseEntity<DescuentoResponse> eliminarDescuento(
            @PathVariable TipoBoleto tipo) {

        descuentoService.eliminarDescuento(tipo);

        DescuentoResponse respuesta = new DescuentoResponse(
                tipo,
                null,
                "Descuento eliminado"
        );

        return ResponseEntity.ok(respuesta);
    }
}
