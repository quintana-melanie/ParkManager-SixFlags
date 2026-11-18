package com.parkmanager.dto;

import java.math.BigDecimal;

public class EstadisticasResponse {

    private final int boletosVendidos;
    private final BigDecimal ingresosTotales;

    public EstadisticasResponse(
            int boletosVendidos,
            BigDecimal ingresosTotales) {

        this.boletosVendidos = boletosVendidos;
        this.ingresosTotales = ingresosTotales;
    }

    public int getBoletosVendidos() {
        return boletosVendidos;
    }

    public BigDecimal getIngresosTotales() {
        return ingresosTotales;
    }
}
