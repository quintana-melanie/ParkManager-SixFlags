
package com.parkmanager.dto;

import com.parkmanager.model.TipoBoleto;
import java.math.BigDecimal;

public class DescuentoResponse {

    private TipoBoleto tipo;
    private BigDecimal porcentaje;
    private String mensaje;

    public DescuentoResponse(TipoBoleto tipo, BigDecimal porcentaje, String mensaje) {
        this.tipo = tipo;
        this.porcentaje = porcentaje;
        this.mensaje = mensaje;
    }

    public TipoBoleto getTipo() {
        return tipo;
    }

    public BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}

