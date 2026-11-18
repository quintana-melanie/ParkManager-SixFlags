
package com.parkmanager.exception;

import com.parkmanager.dto.ErrorResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SolicitudInvalidaException.class)
    public ResponseEntity<ErrorResponse> manejarSolicitudInvalida(
            SolicitudInvalidaException ex) {

        ErrorResponse error = new ErrorResponse(
                ex.getCodigo(),
                ex.getMessage());

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> manejarFormatoInvalido(
            HttpMessageNotReadableException ex) {

        String codigo = "SOLICITUD_INVALIDA";
        String mensaje =
                "El cuerpo de la solicitud contiene datos inválidos";

        if (ex.getMessage() != null &&
                ex.getMessage().contains("TipoBoleto")) {

            codigo = "TIPO_BOLETO_INVALIDO";
            mensaje = "El tipo de boleto no es válido";
        }

        ErrorResponse error = new ErrorResponse(codigo, mensaje);

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> manejarArgumentoInvalido(
            IllegalArgumentException ex) {

        ErrorResponse error = new ErrorResponse(
                "DATOS_INVALIDOS",
                ex.getMessage());

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> manejarTipoInvalido(
            MethodArgumentTypeMismatchException ex) {

        ErrorResponse error = new ErrorResponse(
                "TIPO_BOLETO_INVALIDO",
                "El tipo de boleto no es válido");

        return ResponseEntity.badRequest().body(error);
    }
}
