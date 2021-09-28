package com.claudio.escuela.servicios.contratos;

import com.claudio.escuela.modelo.entidad.Persona;

import java.util.Optional;

public interface PersonaDAO {
    //Los metodos utilizan la clase persona por la herencia, es decir una persona es un alumno
    Optional<Persona> findById(Integer id);
    Persona save(Persona alumno);
    Iterable<Persona> findAll();
    void deleteById(Integer id);
}
