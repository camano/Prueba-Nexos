package com.jonathan.pruebanexobackend.entity;

import javax.persistence.*;

@Entity
@Table(name = "cargo")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCarro;
    private String nombre;

    public Cargo() {
    }

    public Cargo(String nombre) {
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

    @java.lang.Override
    public String toString() {
        return "Cargo{" + "idCarro=" + idCarro + ", nombre='" + nombre + '\'' + '}';
    }
}
