package com.jonathan.pruebanexobackend.dto;

public class CargoDto {
    private Integer idCarro;
    private String nombre;

    public CargoDto() {
    }

    public CargoDto(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(Integer idCarro) {
        this.idCarro = idCarro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "CargoDto{" + "idCarro=" + idCarro + ", nombre='" + nombre + '\'' + '}';
    }
}
