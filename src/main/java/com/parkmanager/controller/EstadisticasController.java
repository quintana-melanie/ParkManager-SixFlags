package com.parkmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkmanager.dto.EstadisticasResponse;
import com.parkmanager.service.CompraService;

@RestController
@RequestMapping("/api/estadisticas")
public class EstadisticasController {

    private final CompraService compraService;

    public EstadisticasController(CompraService compraService) {
        this.compraService = compraService;
    }

    @GetMapping
    public EstadisticasResponse obtenerEstadisticas() {
        return new EstadisticasResponse(
            compraService.obtenerTotalBoletosVendidos(),
            compraService.obtenerIngresosTotales()
        );
    }
}