package com.claudio.escuela.servicios.implementaciones;

import com.claudio.escuela.Repositorios.CarreraRepository;
import com.claudio.escuela.modelo.entidad.Carrera;
import com.claudio.escuela.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service //se tiene que agregar este descorador para que spring boot lo reconozca como un servicio
public class CarreraDAOImpl implements CarreraDAO {
    //Crear instancia de carrera repository para tener acceso a los metodos de la interfaz
    @Autowired //Indica la inyeccion de la dependencia carreraRepository
    private CarreraRepository carreraRepository;

    @Override
    @Transactional(readOnly = true)//Indica el tipo de transaccion a utilizar es decir de spring boot y no de java
    public Optional<Carrera> findByid(Integer id) {
        return carreraRepository.findById(id);
    }

    @Override
    @Transactional
    public Carrera save(Carrera carrera) {
        return carreraRepository.save(carrera);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Carrera> findAll() {
        return carreraRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        carreraRepository.deleteById(id);
    }
}
