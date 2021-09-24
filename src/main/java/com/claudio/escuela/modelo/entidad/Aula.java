package com.claudio.escuela.modelo.entidad;

import com.claudio.escuela.modelo.entidad.enumeradores.TipoPizarra;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "aulas")
public class Aula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "num_aula", nullable = false)
    private Integer numeroAula;
    @Column(name = "medidas_metros")
    private String medidas;
    @Column(name = "cant_butacas")
    private Integer cantidadButacas;
    @Column(name = "tipo_pizarron")
    @Enumerated(EnumType.STRING) //El tipo de dato enum sera estring obtenido de la clase enum TipoPizarra
    private TipoPizarra tipoPizarra;
    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;
    @Column(name = "fecha_modificacion")
    private LocalDateTime fechaModificacion;

    /**
     * Muchas aulas van a pertenecer a un pabellon por lo tanto generamos la relacion de
     * unos a muchos mediante el siguiente codigo
     */

    @ManyToOne(
            optional = true,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(
            name = "pabellon_id",
            foreignKey = @ForeignKey(name = "FK_PABELLON_ID")
    )
    private Pabellon pabellon;//Es nesesario crear los respectivos getters and setters

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

    public Pabellon getPabellon() {
        return pabellon;
    }

    public void setPabellon(Pabellon pabellon) {
        this.pabellon = pabellon;
    }

    /**
     * Crear metodos privados que se encargen de instancias las fechas de alta y fecha de modificacion
     * para que sean persistentes en todos los objetos que sean utilizados
     */

    @PrePersist
    private void antesDePersistir(){
        this.fechaAlta = LocalDateTime.now();
    }

    @PreUpdate
    private void antesDeActualizar(){
        this.fechaModificacion = LocalDateTime.now();
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
