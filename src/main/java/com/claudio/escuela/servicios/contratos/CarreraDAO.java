package com.claudio.escuela.servicios.contratos;

import com.claudio.escuela.modelo.entidad.Carrera;

import java.util.Optional;

/**
 * DAO data accces option, se establecen todos los metodos a utilizar pra realizar un Crud de carreras
 * que se implementaran en la clase carreraDAOImpl del paquete implementaciones
 */

public interface CarreraDAO extends GenericoDAO<Carrera>{
    /**
     * Esta interfaz utilizara los metodos heredados de la interfaz GenericoDAO
     *Enviando como parametro a GenericoDAO<Carrera> el objeto a utilizar
     */

}
