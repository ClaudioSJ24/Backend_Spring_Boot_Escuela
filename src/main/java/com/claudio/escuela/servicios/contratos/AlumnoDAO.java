package com.claudio.escuela.servicios.contratos;


import com.claudio.escuela.modelo.entidad.Persona;

/**
 * DAO data accces option, se establecen todos los metodos a utilizar pra realizar un Crud de carreras
 * que se implementaran en la clase carreraDAOImpl del paquete implementaciones
 */
public interface AlumnoDAO extends PersonaDAO {
    /**
     * /Los metodos a implementar en alumnosDAO estan contenidos en PersonasDAO,
     * Para hacer uso de ellos solo es nesesario  heredar de PersonasDAO
     */

    //Consulta JQPL, este metodo tiene que estar en AlumnoRepository para asi poder utilizarlo en la clase AlumnoDAOImpl
    Iterable<Persona> buscarAlumnoCarrera(String carreraA);



}
