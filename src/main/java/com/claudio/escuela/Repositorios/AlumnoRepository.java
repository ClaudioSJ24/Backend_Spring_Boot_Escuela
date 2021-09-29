package com.claudio.escuela.Repositorios;

import com.claudio.escuela.modelo.entidad.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("repositorioAlumnos")//nombre de acceso al repositorio y tiene que heredar de PersonaRepository y no de CrudRepository
public interface AlumnoRepository extends PersonaRepository {
    //Consulta JQPL, este metodo tiene que estar en AlumnoDAO

    @Query("select a from Alumno a where a.carrera.nombre = ?1")//?1 es el argumento que recibira el metodo
    Iterable<Persona> buscarAlumnoCarrera(String carreraA);
}
