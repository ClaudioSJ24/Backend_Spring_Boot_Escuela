package com.claudio.escuela.modelo.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "alumnos")
@PrimaryKeyJoinColumn(name = "persona_id")//Establece llave primaria a utilizar para los joins
public class Alumno extends Persona {

    /**
     * Establecer una relacion de muchos a uno ya que muchos alumnos pueden
     * cursar la misma carrera
     */
    @ManyToOne(
            optional = true,
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(name = "carrera_id")
    @JsonIgnoreProperties({
            "hibernateLazyInitializer", "alumnos"
    })
    private Carrera carrera;//generar setters and getters
    public Alumno() {
    }

    public Alumno(Integer id, String nombre, String apellido, String dni, Direccion direccion) {
        super(id, nombre, apellido, dni, direccion);
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }


    //Se genera el metodo despues de crear las relaciones de herencia
    //se omite el atributo carrera para agregarlo manualmente con super

    @Override
    public String toString() {
        return super.toString()+
                "\tAlumno{}";//las propiedades se obtienen de la clase padre
    }
}
