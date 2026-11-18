
package com.parkmanager.dto;

import com.parkmanager.model.Compra;
import java.math.BigDecimal;

public class CompraResponse {

    private final String tipo;
    private final int cantidad;
    private final BigDecimal precioBase;
    private final BigDecimal descuentoAplicado;
    private final BigDecimal precioUnitarioFinal;
    private final BigDecimal total;
    private final BigDecimal ingresosAcumulados;

    public CompraResponse(Compra compra) {
        this.tipo = compra.getTipo().name();
        this.cantidad = compra.getCantidad();
        this.precioBase = compra.getPrecioBase();
        this.descuentoAplicado = compra.getDescuentoAplicado();
        this.precioUnitarioFinal = compra.getPrecioUnitarioFinal();
        this.total = compra.getTotal();
        this.ingresosAcumulados = compra.getIngresosAcumulados();
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public BigDecimal getPrecioBase() {
        return precioBase;
    }

    public BigDecimal getDescuentoAplicado() {
        return descuentoAplicado;
    }

    public BigDecimal getPrecioUnitarioFinal() {
        return precioUnitarioFinal;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public BigDecimal getIngresosAcumulados() {
        return ingresosAcumulados;
    }
}
