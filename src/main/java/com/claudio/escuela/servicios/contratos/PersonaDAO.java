package com.claudio.escuela.servicios.contratos;

import com.claudio.escuela.modelo.entidad.Persona;

import java.util.Optional;

public interface PersonaDAO extends GenericoDAO<Persona>{
    /**
     * Esta interfaz utilizara los metodos heredados de la interfaz GenericoDAO
     *Enviando como parametro a GenericoDAO<Persona> el objeto a utilizar
     */

    //Filtro de busquedas mediante JPQL estos metodos tambien deben estar definidos en PersonaRepository

    Optional<Persona> buscarNombreApellido(String nombre, String apellido);
    Optional<Persona> buscarDNI(String dni);
    Iterable<Persona> buscarPersonaApellido(String apellido);
}
