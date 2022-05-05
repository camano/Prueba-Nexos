package com.jonathan.pruebanexobackend.entity;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "mercancia")
public class Mercancia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMercancia;
    @Column(unique = true , length = 30)
    private String nombreProducto;
    private Long cantidad;
    private LocalDate fechaIngreso;
    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "usuario_id",nullable = false)
    private Usuario usuario;

    public Mercancia() {
    }

    public Mercancia(String nombreProducto, Long cantidad, LocalDate fechaIngreso, Usuario usuario) {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Mercancia{" + "idMercancia=" + idMercancia + ", nombreProducto='" + nombreProducto + '\'' + ", cantidad=" + cantidad + ", fechaIngreso=" + fechaIngreso + ", usuario=" + usuario + '}';
    }
}
