package com.parkmanager.model;

import java.math.BigDecimal;

public class BoletoAnual extends Boleto {

    private static final BigDecimal PRECIO_BASE =
            new BigDecimal("2400.00");

    public BoletoAnual() {
        super(TipoBoleto.PASE_ANUAL);
    }

    public BigDecimal getPrecioBase() {
        return PRECIO_BASE;
    }
}
