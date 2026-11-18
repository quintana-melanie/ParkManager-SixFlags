
package com.parkmanager.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Compra {

    private final TipoBoleto tipo;
    private final int cantidad;
    private final BigDecimal precioBase;
    private final BigDecimal descuentoAplicado;
    private final BigDecimal precioUnitarioFinal;
    private final BigDecimal total;
    private final BigDecimal ingresosAcumulados;

    public Compra(
            TipoBoleto tipo,
            int cantidad,
            BigDecimal precioBase,
            BigDecimal descuentoAplicado,
            BigDecimal precioUnitarioFinal,
            BigDecimal ingresosAcumulados) {

        this.tipo = Objects.requireNonNull(tipo);
        this.cantidad = cantidad;
        this.precioBase = Objects.requireNonNull(precioBase);
        this.descuentoAplicado =
                Objects.requireNonNull(descuentoAplicado);
        this.precioUnitarioFinal =
                Objects.requireNonNull(precioUnitarioFinal);

        this.total = precioUnitarioFinal
                .multiply(BigDecimal.valueOf(cantidad))
                .setScale(2, RoundingMode.HALF_UP);

        this.ingresosAcumulados =
                Objects.requireNonNull(ingresosAcumulados);
    }

    public TipoBoleto getTipo() {
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
