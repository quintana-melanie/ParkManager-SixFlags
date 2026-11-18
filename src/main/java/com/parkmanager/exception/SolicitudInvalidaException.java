package com.parkmanager.exception;

public class SolicitudInvalidaException extends RuntimeException {

    private final String codigo;

    public SolicitudInvalidaException(String codigo, String mensaje) {
        super(mensaje);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}