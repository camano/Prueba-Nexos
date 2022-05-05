package com.jonathan.pruebanexobackend.dto;

public class MensajeDto {
    private String mensaje;

    public MensajeDto() {
    }

    public MensajeDto(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "MensajeDto{" + "mensaje='" + mensaje + '\'' + '}';
    }
}
