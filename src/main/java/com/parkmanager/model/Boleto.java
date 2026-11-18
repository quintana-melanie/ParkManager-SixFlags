package com.parkmanager.model;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Boleto {

    private final TipoBoleto tipo;

    protected Boleto(TipoBoleto tipo) {
        this.tipo = Objects.requireNonNull(tipo);
    }

    public TipoBoleto getTipo() {
        return tipo;
    }

    public abstract BigDecimal getPrecioBase();
}