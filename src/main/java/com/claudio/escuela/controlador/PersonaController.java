package com.claudio.escuela.controlador;

import com.claudio.escuela.exception.BandRequestException;
import com.claudio.escuela.modelo.entidad.Persona;
import com.claudio.escuela.servicios.contratos.PersonaDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public class PersonaController extends GenericController<Persona, PersonaDAO> {

    public PersonaController(PersonaDAO genericoDAOServicio) {
        super(genericoDAOServicio);
    }
    @GetMapping("/nombre-apellido")
    //localhost://9089/alumnos/nombre-apellido?nombre=claudio&apellido=sanchez
    public Persona findPersonByNameLastname(@RequestParam String name,@RequestParam String lastname){
        Optional<Persona> findPersonNL = genericoDAOServicio.buscarNombreApellido(name, lastname);
        if(!findPersonNL.isPresent()){
            throw new BandRequestException(String.format("El nombre %s y apellido %s no existe", name,lastname));
        }

        return findPersonNL.get();
    }
}
