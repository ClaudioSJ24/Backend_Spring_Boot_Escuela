package com.claudio.escuela.Repositorios;

import com.claudio.escuela.modelo.entidad.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository //Es opcional
public interface CarreraRepository extends CrudRepository<Carrera,Integer> {

    /**
     * //Crear consultas JPA atraves de metodos
     * Estos metodos tienen que estar en interfaz CarreraDAO
     * Estos metodos tienen que tener el nombre de la @Table(name = "Carreras") ingresado en la clase Carrera
     * Asi, como utilizar la misma propiedad private Integer "duracionCarrera"; y private Integer "nombre" de la clase Carrera
     * para poder asi ser ejecutados de forma correcta
     */

    //@Query("select c from Carrera c where c.nombre like %?1%")
    Iterable<Carrera> findCarrerasByNombreContains(String nombre);
    //Query("select c from Carrera c where upper(c.nombre) like upper(%?1%)")
    Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
    //Query("select c from Carrera c where c.duracion_carrera > ?1")
    Iterable<Carrera> findCarrerasByDuracionCarreraAfter(Integer duracionCarrera);

}
