package com.parkmanager.dto;

public class ErrorResponse {

    private final String codigo;
    private final String mensaje;

    public ErrorResponse(String codigo, String mensaje) {
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensaje() {
        return mensaje;
    }
}