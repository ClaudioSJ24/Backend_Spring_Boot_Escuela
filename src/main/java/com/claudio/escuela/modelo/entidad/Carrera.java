package com.claudio.escuela.modelo.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Carreras")
public class Carrera implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true, length = 40)
    private String nombre;
    @Column(name = "numero_materias")
    private Integer numeroMaterias;
    @Column(name = "duracion_carrera")
    private Integer duracionCarrera;
    @Column(name = "fecha_alta")
    private LocalDateTime fechaAlta;
    @Column(name = "fecha_mofificacion")
    private LocalDateTime fechaModificacion;

    @OneToMany(
            mappedBy = "carrera",
            fetch = FetchType.LAZY
    )
    /**
     * esta propiedad ignora la propiedad(atributo) carrera de la Clase Alumnos para que al ser
     * consultadas todas las carreras no tome en cuenta el atributo carrera y salga del ciclo infinito en el que se
     * encuentra y pueda generar una consulta de las carreras de forma optima
     *
     */
    @JsonIgnoreProperties({"carrera"})
    private Set<Alumno> alumnos;

    @ManyToMany(
            mappedBy = "carreras",
            fetch = FetchType.LAZY
    )
    /**
     * esta propiedad ignora la propiedad(atributo) carreras de la Clase profesor para que al ser
     * consultadas todas las carreras no tome en cuenta el atributo carrera y salga del ciclo infinito en el que se
     * encuentra y pueda generar una consulta de las carreras de forma optima
     *
     */
    @JsonIgnoreProperties({"carreras"})
    private Set<Profesor> profesores;
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

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Set<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<Profesor> profesores) {
        this.profesores = profesores;
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
