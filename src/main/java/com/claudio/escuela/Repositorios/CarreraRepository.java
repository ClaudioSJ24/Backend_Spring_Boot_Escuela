package com.claudio.escuela.Repositorios;

import com.claudio.escuela.modelo.entidad.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository //Es opcional
public interface CarreraRepository extends CrudRepository<Carrera,Integer> {
}
