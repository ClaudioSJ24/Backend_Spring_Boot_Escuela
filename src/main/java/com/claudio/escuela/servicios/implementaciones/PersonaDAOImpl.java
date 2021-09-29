package com.claudio.escuela.servicios.implementaciones;

import com.claudio.escuela.Repositorios.PersonaRepository;
import com.claudio.escuela.modelo.entidad.Persona;
import com.claudio.escuela.servicios.contratos.PersonaDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class PersonaDAOImpl extends GenericoDAOImpl<Persona, PersonaRepository> implements PersonaDAO {


    public PersonaDAOImpl(PersonaRepository repository) {

        super(repository);
    }

    @Override
    @Transactional(readOnly = true)//Metodos de solo lectura
    public Optional<Persona> buscarNombreApellido(String nombre, String apellido) {
        return repository.buscarNombreApellido(nombre, apellido);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Persona> buscarDNI(String dni) {
        return repository.buscarDNI(dni);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Persona> buscarPersonaApellido(String apellido) {
        return repository.buscarPersonaApellido(apellido);
    }
}
