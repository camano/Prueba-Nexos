package com.jonathan.pruebanexobackend.excepciones;

import org.springframework.http.HttpStatus;

public class MercanciaException extends RuntimeException {

    private HttpStatus estado;
    private String mensaje;

    public MercanciaException(HttpStatus estado, String mensaje) {
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public HttpStatus getEstado() {
        return estado;
    }

    public void setEstado(HttpStatus estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "MercanciaException{" + "estado=" + estado + ", mensaje='" + mensaje + '\'' + '}';
    }
}
