package com.claudio.escuela.modelo.entidad;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Pabellon  implements Serializable {

    private Integer id;
    private Double mtr2;
    private String nombre;
    private Direccion direccion;
    private LocalDateTime fechaAlta;
    private LocalDateTime fechaModificacion;

    public Pabellon() {
    }

    public Pabellon(Integer id, Double mtr2, String nombre, Direccion direccion) {
        this.id = id;
        this.mtr2 = mtr2;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMtr2() {
        return mtr2;
    }

    public void setMtr2(Double mtr2) {
        this.mtr2 = mtr2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
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
    public String toString() {
        return "Pabellon{" +
                "id=" + id +
                ", mtr2=" + mtr2 +
                ", nombre='" + nombre + '\'' +
                ", direccion=" + direccion +
                ", fechaAlta=" + fechaAlta +
                ", fechaUltimaModificacion=" + fechaModificacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pabellon pabellon = (Pabellon) o;
        return id.equals(pabellon.id) &&
                nombre.equals(pabellon.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}
