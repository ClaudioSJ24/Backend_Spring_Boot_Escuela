package com.claudio.escuela.controlador;

import com.claudio.escuela.exception.BandRequestException;
import com.claudio.escuela.modelo.entidad.Persona;
import com.claudio.escuela.servicios.contratos.PersonaDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PersonaController extends GenericController<Persona, PersonaDAO> {

    public PersonaController(PersonaDAO genericoDAOServicio) {
        super(genericoDAOServicio);
    }
    @GetMapping("/nombre-apellido")
    //localhost://9089/alumnos/nombre-apellido?nombre=claudio&apellido=sanchez
    public ResponseEntity<?> findPersonByNameLastname(@RequestParam String name, @RequestParam String lastname){
        Map<String,Object> message = new HashMap<>();
        Optional<Persona> findPersonNL = genericoDAOServicio.buscarNombreApellido(name, lastname);
        if(!findPersonNL.isPresent()){
            //throw new BandRequestException(String.format("El nombre %s y apellido %s no existe", name,lastname));
            message.put("Succes", Boolean.FALSE);
            message.put("Mensaje", String.format("EL nombre %s o apellido %s no son correctos", name, lastname));
            return ResponseEntity.badRequest().body(message);
        }
        message.put("Success", Boolean.TRUE);
        message.put("Datos", findPersonNL.get());
        return ResponseEntity.ok(message);
    }
}
