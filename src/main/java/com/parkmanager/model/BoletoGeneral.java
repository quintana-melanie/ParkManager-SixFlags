
package com.parkmanager.model;

import java.math.BigDecimal;

public class BoletoGeneral extends Boleto {

    private static final BigDecimal PRECIO_BASE =
            new BigDecimal("900.00");

    public BoletoGeneral() {
        super(TipoBoleto.GENERAL);
    }

    public BigDecimal getPrecioBase() {
        return PRECIO_BASE;
    }
}
