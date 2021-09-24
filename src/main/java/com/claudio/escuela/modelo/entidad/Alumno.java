package com.claudio.escuela.modelo.entidad;

import java.io.Serializable;

public class Alumno extends Persona {

    public Alumno() {
    }

    public Alumno(Integer id, String nombre, String apellido, String dni, Direccion direccion) {
        super(id, nombre, apellido, dni, direccion);
    }
}
