package com.parkmanager.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.parkmanager.exception.SolicitudInvalidaException;

public class Descuento {

    private BigDecimal porcentaje;

    public Descuento(BigDecimal porcentaje) {
        establecerPorcentaje(porcentaje);
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void establecerPorcentaje(BigDecimal porcentaje) {
       if (porcentaje == null
        || porcentaje.compareTo(BigDecimal.ZERO) < 0
        || porcentaje.compareTo(new BigDecimal("100")) > 0) {

    throw new SolicitudInvalidaException(
            "DESCUENTO_INVALIDO",
            "El descuento debe estar entre 0 y 100");
         }

        this.porcentaje = porcentaje;
    }

    public BigDecimal aplicar(BigDecimal precioBase) {
    BigDecimal porcentajeRestante =
            new BigDecimal("100").subtract(porcentaje);

    return precioBase.multiply(porcentajeRestante)
            .divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP);
}
}