package com.parkmanager.model;
import java.util.Map;

public class BoletoFactory {

    private static final Map<TipoBoleto, Boleto> BOLETOS = Map.of(
            TipoBoleto.GENERAL, new BoletoGeneral(),
            TipoBoleto.PASE_ANUAL, new BoletoAnual(),
            TipoBoleto.ALUMNO, new BoletoAlumno(),
            TipoBoleto.PROFESOR, new BoletoProfesor()
    );

    public static Boleto crear(TipoBoleto tipo) {
        Boleto boleto = BOLETOS.get(tipo);

        if (boleto == null) {
            throw new IllegalArgumentException("Tipo de boleto no válido");
        }

        return boleto;
    }
}
