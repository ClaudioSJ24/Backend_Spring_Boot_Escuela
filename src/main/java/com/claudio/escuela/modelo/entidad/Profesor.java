package com.claudio.escuela.modelo.entidad;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "profesores")
@PrimaryKeyJoinColumn(name = "persona_id")//establece la llave primaria para realizar joins
public class Profesor extends Persona {
    //BigDecimal permite agregar decimales con el simbolo de moneda $ 90.0
    private BigDecimal sueldo;

    /**
     * Establecer relacion de unos a muchos debido a que varias carreras pueden pertenecer a un profesor
     * y varios pofesores pueden tener una carrera
     */
    @ManyToMany(
            fetch = FetchType.LAZY,//es recomendado utilizar la busqueda peresoza en relacion muchos a muchos
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }

    )

    //permite la decoracion de la tabla intermedia
    @JoinTable(
            //nombre de tabla
            name = "profesor_carrera",
            //clase actual
            joinColumns = @JoinColumn(name = "profesor_id"),
            //clase a la que hace la referencia
            inverseJoinColumns = @JoinColumn(name = "carrera_id")
    )
    //generar setters and getters
    private Set<Carrera> carreras;//Set permite tener instancias no repetidas de carreras
    public Profesor() {
    }

    public Profesor(Integer id, String nombre, String apellido, String dni, Direccion direccion, BigDecimal sueldo) {
        super(id, nombre, apellido, dni, direccion);
        this.sueldo = sueldo;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public Set<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(Set<Carrera> carreras) {
        this.carreras = carreras;
    }
    //Se crea en metodo toString al realizar las relaciones de herencia
    //se omite el atributo de carrera y se genera manualmente

    @Override
    public String toString() {
        return super.toString()+
                "\tProfesor{" +
                "sueldo=" + sueldo +
                '}';
    }
}

