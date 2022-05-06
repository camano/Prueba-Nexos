package com.jonathan.pruebanexobackend.excepciones;

import com.jonathan.pruebanexobackend.dto.MensajeDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MercanciaException.class)
    public ResponseEntity<MensajeDto> manejarMercanciaException(MercanciaException mercanciaException, WebRequest webRequest) {

        MensajeDto mensajeDto = new MensajeDto(mercanciaException.getMensaje());

        return new ResponseEntity<>(mensajeDto, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MensajeDto> manejarGlobalException(Exception exception, WebRequest webRequest) {

        MensajeDto mensajeDto = new MensajeDto(exception.getMessage());
        return new ResponseEntity<>(mensajeDto, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> errores = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String nombreCampo = ((FieldError) error).getField();
            String mensaje = error.getDefaultMessage();

            errores.put(nombreCampo, mensaje);
        });

        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }

}
