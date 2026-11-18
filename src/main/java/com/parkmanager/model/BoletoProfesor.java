package com.parkmanager.model;

import java.math.BigDecimal;

public class BoletoProfesor extends Boleto {

    private static final BigDecimal PRECIO_BASE =
            new BigDecimal("700.00");

    public BoletoProfesor() {
        super(TipoBoleto.PROFESOR);
    }

    public BigDecimal getPrecioBase() {
        return PRECIO_BASE;
    }
}

