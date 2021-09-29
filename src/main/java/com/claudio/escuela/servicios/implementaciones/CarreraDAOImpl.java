package com.claudio.escuela.servicios.implementaciones;

import com.claudio.escuela.Repositorios.CarreraRepository;
import com.claudio.escuela.modelo.entidad.Carrera;
import com.claudio.escuela.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
    public Iterable<Carrera> findCarrerasByNameContains(String nombre) {
        return repository.findCarrerasByNameContains(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByNameIgnoreCase(String nombre) {
        return repository.findCarrerasByNameIgnoreCase(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findCarrerasByAmountYears(Integer amountY) {
        return repository.findCarrerasByAmountYears(amountY);
    }
}
