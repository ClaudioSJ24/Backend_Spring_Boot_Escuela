package com.claudio.escuela.modelo.entidad;

import com.claudio.escuela.modelo.entidad.enumeradores.TipoEmpleado;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name = "empleados")
@PrimaryKeyJoinColumn(name = "persona_id")//atributo que permitira hacer los joins con la tabla persona
public class Empleado extends Persona {

    //no se le agrega ningun decorador por default tomara el nombre de la variable
    private BigDecimal sueldo;
    @Column(name = "tipo_empleado")
    @Enumerated(EnumType.STRING)//propiedad que especifica el tipo de atributo de la clase enum TipoEMmpleado
    private TipoEmpleado tipoEmpleado;

    /**
     * Establecer relación uno a uno debido a que un empleado le corresponde un unico pabellon
     */
    @OneToOne(
            optional = true,
            cascade = CascadeType.ALL//por ser una relacion de uno a uno
    )

    //Decorador que permite establecer los campos al realizar un join
    @JoinColumn(
            name = "pabellon_id",
            foreignKey = @ForeignKey(name = "FK_PABELLON_ID")
    )
    private Pabellon pabellon;//Establecer metodos setters and getters
    public Empleado() {
    }

    public Empleado(Integer id, String nombre, String apellido, String dni, Direccion direccion, BigDecimal sueldo, TipoEmpleado tipoEmpleado) {
        super(id, nombre, apellido, dni, direccion);
        this.sueldo = sueldo;
        this.tipoEmpleado = tipoEmpleado;
    }

    public BigDecimal getSueldo() {
        return sueldo;
    }

    public void setSueldo(BigDecimal sueldo) {
        this.sueldo = sueldo;
    }

    public TipoEmpleado getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public Pabellon getPabellon() {
        return pabellon;
    }

    public void setPabellon(Pabellon pabellon) {
        this.pabellon = pabellon;
    }
    //Cuando existe herencia de una clase el metodo toString se sobreescibe despues de crear las relaciones nesesarias
    //Al generar el metodo quitar omitir el atributo pabellon y agregarlo manualmente con super()

    @Override
    public String toString() {
        return super.toString()+
                "\tEmpleado{" +
                "sueldo=" + sueldo +
                ", tipoEmpleado=" + tipoEmpleado +
                '}';
    }
    /*@Override
    public String toString() {
        return "Empleado{" +
                "sueldo=" + sueldo +
                ", tipoEmpleado=" + tipoEmpleado +
                ", pabellon=" + pabellon +
                '}';
    }*/


}
