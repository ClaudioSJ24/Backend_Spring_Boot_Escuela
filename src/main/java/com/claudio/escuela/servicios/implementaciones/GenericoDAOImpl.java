package com.claudio.escuela.servicios.implementaciones;

import com.claudio.escuela.servicios.contratos.GenericoDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class GenericoDAOImpl <E, R extends CrudRepository<E, Integer>> implements GenericoDAO<E> {

    protected final R repository; //variable de repositorio generico

    //Inicializar constructor con  variable generica

    public GenericoDAOImpl(R repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional findByid(Integer id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public E save(E entidad) {
        return repository.save(entidad);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<E> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
