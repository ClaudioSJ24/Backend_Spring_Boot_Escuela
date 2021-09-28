package com.claudio.escuela.servicios.contratos;

import com.claudio.escuela.modelo.entidad.Alumno;
import com.claudio.escuela.modelo.entidad.Carrera;
import com.claudio.escuela.modelo.entidad.Persona;

import java.util.Optional;

/**
 * DAO data accces option, se establecen todos los metodos a utilizar pra realizar un Crud de carreras
 * que se implementaran en la clase carreraDAOImpl del paquete implementaciones
 */
public interface AlumnoDAO {
    //Los metodos utilizan la clase persona por la herencia, es decir una persona es un alumno
    Optional<Persona> findById(Integer id);
    Persona save(Persona alumno);
    Iterable<Persona> findAll();
    void deleteById(Integer id);


}
