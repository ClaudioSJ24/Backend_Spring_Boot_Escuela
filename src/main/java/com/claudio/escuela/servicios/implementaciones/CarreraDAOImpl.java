package com.claudio.escuela.servicios.implementaciones;

import com.claudio.escuela.Repositorios.CarreraRepository;
import com.claudio.escuela.modelo.entidad.Carrera;
import com.claudio.escuela.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //se tiene que agregar este descorador para que spring boot lo reconozca como un servicio
//Uso de genericos atravez de entidades (Carrera) y repositorios(carreraRepository)
public class CarreraDAOImpl extends GenericoDAOImpl<Carrera, CarreraRepository> implements CarreraDAO {

    @Autowired
    //Crear constructor padre para poder utilizar repository de CarreraRepository
    public CarreraDAOImpl(CarreraRepository repository) {
        super(repository);
    }


    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByNombreContains(String nombre) {
        return repository.findCarrerasByNombreContains(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre) {
        return repository.findCarrerasByNombreContainsIgnoreCase(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByDuracionCarreraAfter(Integer duracionCarrera) {
        return repository.findCarrerasByDuracionCarreraAfter(duracionCarrera);
    }


}
