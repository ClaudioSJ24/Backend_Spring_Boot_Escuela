package com.claudio.escuela.modelo.entidad;

import com.claudio.escuela.modelo.entidad.enumeradores.TipoPizarra;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Aula implements Serializable {

    private Integer id;
    private Integer numeroAula;
    private String medidas;
    private Integer cantidadButacas;
    private TipoPizarra tipoPizarra;
    private LocalDateTime fechaAlta;
    private LocalDateTime fechaModificacion;

    public Aula() {
    }

    public Aula(Integer id, Integer numeroAula, String medidas, Integer cantidadButacas, TipoPizarra tipoPizarra) {
        this.id = id;
        this.numeroAula = numeroAula;
        this.medidas = medidas;
        this.cantidadButacas = cantidadButacas;
        this.tipoPizarra = tipoPizarra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroAula() {
        return numeroAula;
    }

    public void setNumeroAula(Integer numeroAula) {
        this.numeroAula = numeroAula;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public Integer getCantidadButacas() {
        return cantidadButacas;
    }

    public void setCantidadButacas(Integer cantidadButacas) {
        this.cantidadButacas = cantidadButacas;
    }

    public TipoPizarra getTipoPizarra() {
        return tipoPizarra;
    }

    public void setTipoPizarra(TipoPizarra tipoPizarra) {
        this.tipoPizarra = tipoPizarra;
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
        return "Aula{" +
                "id=" + id +
                ", numeroAula=" + numeroAula +
                ", medidas='" + medidas + '\'' +
                ", cantidadButacas=" + cantidadButacas +
                ", tipoPizarra=" + tipoPizarra +
                ", fechaAlta=" + fechaAlta +
                ", fechaUltimaModificacion=" + fechaModificacion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aula aula = (Aula) o;
        return id.equals(aula.id) &&
                numeroAula.equals(aula.numeroAula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numeroAula);
    }
}
