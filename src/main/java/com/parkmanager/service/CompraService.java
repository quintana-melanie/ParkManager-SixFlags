
package com.parkmanager.service;

import com.parkmanager.model.Boleto;
import com.parkmanager.model.BoletoFactory;
import com.parkmanager.model.Compra;
import com.parkmanager.model.TipoBoleto;

import com.parkmanager.exception.SolicitudInvalidaException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CompraService {

    private final DescuentoService descuentoService;

    private final Map<TipoBoleto, Integer> boletosVendidos =
            new EnumMap<>(TipoBoleto.class);

    private BigDecimal ingresosTotales =
            BigDecimal.ZERO.setScale(2);

    public CompraService(DescuentoService descuentoService) {
        this.descuentoService = descuentoService;
    }

    public synchronized Compra realizarCompra(
            TipoBoleto tipo, Integer cantidad) {

        if (tipo == null) {
            throw new SolicitudInvalidaException(
                    "TIPO_BOLETO_INVALIDO",
                    "El tipo de boleto no es válido");
        }

        if (cantidad == null || cantidad < 1 || cantidad > 10) {
            throw new SolicitudInvalidaException(
                    "CANTIDAD_INVALIDA",
                    "La cantidad debe estar entre 1 y 10");
        }

        Boleto boleto = BoletoFactory.crear(tipo);

        BigDecimal precioBase =
                boleto.getPrecioBase().setScale(2, RoundingMode.HALF_UP);

        BigDecimal descuentoAplicado =
                descuentoService.obtenerPorcentaje(tipo);

        BigDecimal precioUnitarioFinal =
                descuentoService.calcularPrecio(tipo, precioBase);

        BigDecimal totalCompra = precioUnitarioFinal
                .multiply(BigDecimal.valueOf(cantidad))
                .setScale(2, RoundingMode.HALF_UP);

        BigDecimal nuevosIngresos = ingresosTotales
                .add(totalCompra)
                .setScale(2, RoundingMode.HALF_UP);

        Compra compra = new Compra(
                tipo,
                cantidad,
                precioBase,
                descuentoAplicado,
                precioUnitarioFinal,
                nuevosIngresos
        );

        boletosVendidos.merge(
                tipo,
                cantidad,
                Integer::sum
        );

        ingresosTotales = nuevosIngresos;

        return compra;
    }

    public synchronized int obtenerBoletosVendidos(TipoBoleto tipo) {
        return boletosVendidos.getOrDefault(tipo, 0);
    }

    public synchronized BigDecimal obtenerIngresosTotales() {
        return ingresosTotales;
    }

    public synchronized int obtenerTotalBoletosVendidos() {
        return boletosVendidos.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
