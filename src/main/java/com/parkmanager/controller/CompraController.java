package com.parkmanager.controller;

import com.parkmanager.dto.CompraRequest;
import com.parkmanager.dto.CompraResponse;
import com.parkmanager.model.Compra;
import com.parkmanager.service.CompraService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/compras")
public class CompraController {

    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping
    public ResponseEntity<CompraResponse> realizarCompra(
            @RequestBody CompraRequest solicitud) {

        Compra compra = compraService.realizarCompra(
                solicitud.getTipo(),
                solicitud.getCantidad());

        return ResponseEntity.ok(new CompraResponse(compra));
    }
}