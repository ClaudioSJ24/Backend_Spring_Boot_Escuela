package com.claudio.escuela.Repositorios;

import com.claudio.escuela.modelo.entidad.Alumno;
import com.claudio.escuela.modelo.entidad.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean//No genera un bean del repositorio como tal, pero si crea el de las clases que heredan de persona, esta clase hereda de CrudRepository
public interface PersonaRepository extends CrudRepository<Persona, Integer>{

    //Filtro de busquedas mediante JPQL estos metodos tambien deben estar definidos en PersonaDAO para poder ser utilizados en clase PersonaDAOImple
    @Query("select p from Persona p where p.nombre = ?1 and p.apellido = ?2")//?1 y ?2 son los argumentos que se pasaran al metodo
    Optional<Persona> buscarNombreApellido(String nombre, String apellido);

    @Query("select p from Persona p where p.dni = ?1")//?1 es el argumento que se pasara al metodo
    Optional<Persona> buscarDNI(String dni);

    @Query("select p from Persona p where p.apellido like %?1%")//?1 es el argumento que se pasara al metodo
    Iterable<Persona> buscarPersonaApellido(String apellido);

}
