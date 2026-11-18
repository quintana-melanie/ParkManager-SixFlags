package com.parkmanager.dto;

import com.parkmanager.model.TipoBoleto;

public class CompraRequest {

    private TipoBoleto tipo;
    private Integer cantidad;

    public TipoBoleto getTipo() {
        return tipo;
    }

    public void setTipo(TipoBoleto tipo) {
        this.tipo = tipo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
