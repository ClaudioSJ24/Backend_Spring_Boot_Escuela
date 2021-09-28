package com.claudio.escuela.servicios.contratos;

import com.claudio.escuela.modelo.entidad.Persona;

import java.util.Optional;

public interface PersonaDAO extends GenericoDAO<Persona>{
    /**
     * Esta interfaz utilizara los metodos heredados de la interfaz GenericoDAO
     *Enviando como parametro a GenericoDAO<Persona> el objeto a utilizar
     */
}
