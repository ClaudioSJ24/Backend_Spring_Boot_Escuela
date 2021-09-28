package com.claudio.escuela.Repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("repositorioAlumnos")//nombre de acceso al repositorio y tiene que heredar de PersonaRepository y no de CrudRepository
public interface AlumnoRepository extends PersonaRepository {
}
