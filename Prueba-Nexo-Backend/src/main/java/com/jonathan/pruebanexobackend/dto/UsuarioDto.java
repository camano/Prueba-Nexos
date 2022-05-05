package com.jonathan.pruebanexobackend.dto;

import java.time.LocalDate;

public class UsuarioDto {
    private Integer idUsuario;
    private String nombre;
    private Long edad;
    private LocalDate fechaIngreso;

    private Integer idCargo;

    public UsuarioDto() {
    }

    public UsuarioDto(String nombre, Long edad, LocalDate fechaIngreso, Integer idCargo) {
        this.nombre = nombre;
        this.edad = edad;
        this.fechaIngreso = fechaIngreso;
        this.idCargo = idCargo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getEdad() {
        return edad;
    }

    public void setEdad(Long edad) {
        this.edad = edad;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    @Override
    public String toString() {
        return "UsuarioDto{" + "idUsuario=" + idUsuario + ", nombre='" + nombre + '\'' + ", edad=" + edad + ", fechaIngreso=" + fechaIngreso + ", idCargo=" + idCargo + '}';
    }
}
