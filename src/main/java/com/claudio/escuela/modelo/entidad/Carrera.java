package com.claudio.escuela.modelo.entidad;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Carrera implements Serializable {
    private Integer id;
    private String nombre;
    private Integer numeroMaterias;
    private Integer duracionCarrera;
    private LocalDateTime fechaAlta;
    private LocalDateTime fechaModificacion;

    public Carrera() {
    }

    public Carrera(Integer id, String nombre, Integer numeroMaterias, Integer duracionCarrera) {
        this.id = id;
        this.nombre = nombre;
        this.numeroMaterias = numeroMaterias;
        this.duracionCarrera = duracionCarrera;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumeroMaterias() {
        return numeroMaterias;
    }

    public void setNumeroMaterias(Integer numeroMaterias) {
        this.numeroMaterias = numeroMaterias;
    }

    public Integer getDuracionCarrera() {
        return duracionCarrera;
    }

    public void setDuracionCarrera(Integer duracionCarrera) {
        this.duracionCarrera = duracionCarrera;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrera carrera = (Carrera) o;
        return id.equals(carrera.id) &&
                nombre.equals(carrera.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}
