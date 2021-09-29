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
     */

    //@Query("select c from Carrera c where c.nombre like %?1%")
    Iterable<Carrera> findCarrerasByNameContains(String nombre);
    //Query("select c from Carrera c where upper(c.nombre) like upper(%?1%)")
    Iterable<Carrera> findCarrerasByNameIgnoreCase(String nombre);
    //Query("select c from Carrera c where c.cantidadAnios > ?1")
    Iterable<Carrera> findCarrerasByAmountYears(Integer amountY);
}
