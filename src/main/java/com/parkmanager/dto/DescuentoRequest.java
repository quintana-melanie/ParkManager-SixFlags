package com.parkmanager.dto;

import java.math.BigDecimal;

public class DescuentoRequest {

    private BigDecimal porcentaje;

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }
}