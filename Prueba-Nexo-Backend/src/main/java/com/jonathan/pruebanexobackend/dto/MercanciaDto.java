package com.jonathan.pruebanexobackend.dto;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class MercanciaDto {

    private Integer idMercancia;

    private String nombreProducto;
    private Long cantidad;
    private LocalDate fechaIngreso;
    private UsuarioDto usuario;

    public MercanciaDto() {
    }

    public MercanciaDto(String nombreProducto, Long cantidad, LocalDate fechaIngreso, UsuarioDto usuario) {
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

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "MercanciaDto{" + "idMercancia=" + idMercancia + ", nombreProducto='" + nombreProducto + '\'' + ", cantidad=" + cantidad + ", fechaIngreso=" + fechaIngreso + ", usuario=" + usuario + '}';
    }
}
