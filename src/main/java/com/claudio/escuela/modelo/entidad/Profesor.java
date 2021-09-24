package com.claudio.escuela.modelo.entidad;

import java.math.BigDecimal;

public class Profesor extends Persona {
    //BigDecimal permite agregar decimales con el simbolo de moneda $ 90.0
    private BigDecimal sueldo;

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
}

