package com.parkmanager.service;

import com.parkmanager.model.Descuento;
import com.parkmanager.model.TipoBoleto;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.parkmanager.exception.SolicitudInvalidaException;

@Service
public class DescuentoService {

    private final Map<TipoBoleto, Descuento> descuentos =
            new EnumMap<>(TipoBoleto.class);

    public void establecerDescuento(
            TipoBoleto tipo, BigDecimal porcentaje) {

        validarTipo(tipo);

        descuentos.put(tipo, new Descuento(porcentaje));
    }

    public void eliminarDescuento(TipoBoleto tipo) {
        validarTipo(tipo);

        descuentos.remove(tipo);
    }

    public BigDecimal calcularPrecio(
            TipoBoleto tipo, BigDecimal precioBase) {

        validarTipo(tipo);

        Descuento descuento = descuentos.get(tipo);

        if (descuento == null) {
            return precioBase.setScale(2);
        }

        return descuento.aplicar(precioBase);
    }

    public BigDecimal obtenerPorcentaje(TipoBoleto tipo) {
    validarTipo(tipo);

    Descuento descuento = descuentos.get(tipo);

    if (descuento == null) {
        return BigDecimal.ZERO;
    }

    return descuento.getPorcentaje();
}
  
private void validarTipo(TipoBoleto tipo) {
    if (tipo == null) {
        throw new SolicitudInvalidaException(
                "TIPO_BOLETO_INVALIDO",
                "El tipo de boleto no es válido");
    }
}
}