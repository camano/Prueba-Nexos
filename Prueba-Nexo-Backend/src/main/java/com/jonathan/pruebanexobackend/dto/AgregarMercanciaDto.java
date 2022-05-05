package com.jonathan.pruebanexobackend.dto;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class AgregarMercanciaDto {

    private Integer idMercancia;
    @NotBlank(message = "El campo nombre no tiene que estar vacio")
    private String nombreProducto;
    private Long cantidad;
    private LocalDate fechaIngreso;
    private Integer usuario;

    public AgregarMercanciaDto() {
    }

    public AgregarMercanciaDto(String nombreProducto, Long cantidad, LocalDate fechaIngreso, Integer usuario) {
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
        this.usuario = usuario;
    }

    public Integer getIdMercancia() {
        return idMercancia;
    }

    public void setIdMercancia(Integer idMercancia) {
        this.idMercancia = idMercancia;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Integer getUsuario() {
        return usuario;
    }

    public void setUsuario(Integer usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "MercanciaDto{" + "idMercancia=" + idMercancia + ", nombreProducto='" + nombreProducto + '\'' + ", cantidad=" + cantidad + ", fechaIngreso=" + fechaIngreso + ", usuario=" + usuario + '}';
    }
}
