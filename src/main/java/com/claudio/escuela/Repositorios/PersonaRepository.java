package com.claudio.escuela.Repositorios;

import com.claudio.escuela.modelo.entidad.Alumno;
import com.claudio.escuela.modelo.entidad.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean//No genera un bean del repositorio como tal, pero si crea el de las clases que heredan de persona, esta clase hereda de CrudRepository
public interface PersonaRepository extends CrudRepository<Persona, Integer>{

}
