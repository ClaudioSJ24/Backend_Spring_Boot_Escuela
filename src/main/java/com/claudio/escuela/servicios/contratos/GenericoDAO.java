package com.claudio.escuela.servicios.contratos;

import com.claudio.escuela.modelo.entidad.Carrera;

import java.util.Optional;

public interface GenericoDAO <E> {

    Optional<E> findByid(Integer id);
    E save(E entidad);
    Iterable<E> findAll();
    void deleteById(Integer id);

}
