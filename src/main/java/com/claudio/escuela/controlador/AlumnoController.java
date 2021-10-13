package com.claudio.escuela.controlador;

import com.claudio.escuela.exception.BandRequestException;
import com.claudio.escuela.modelo.entidad.Alumno;
import com.claudio.escuela.modelo.entidad.Carrera;
import com.claudio.escuela.modelo.entidad.Persona;
import com.claudio.escuela.servicios.contratos.CarreraDAO;
import com.claudio.escuela.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController extends PersonaController{

    //Se establece como una variable final de PersonaDao para que se inicialize mediante el constructor y poder utilizar sus propiedades(variables y metodos)
    //private final PersonaDAO alumnoDAOServicio;
    //Se establece como una variable final de PersonaDao para que se inicialize mediante el constructor y pueda ser utilizada libremente poder utilizar sus propiedades(variables y metodos)
    //y asi poder asignar una carrera a alumno
    private final CarreraDAO carreraDAOServicio;

    @Autowired
    //"alumnoDAOImple" es la clase de donde se obtendran las personasDao de tipo alumno
    public AlumnoController(@Qualifier("alumnoDAOImpl") PersonaDAO alumnoDAOServicio, CarreraDAO carreraDAOServicio) {
        //this.alumnoDAOServicio = alumnoDAOServicio;
        super(alumnoDAOServicio);
        nombreEntidad = "Alumno";
        this.carreraDAOServicio = carreraDAOServicio;
    }


    @PutMapping("/{idAlumno}/carrera/{idCarrera}")
    public ResponseEntity<?> addCarreraAlumno(@PathVariable Integer idAlumno, @PathVariable Integer idCarrera){
        Map<String,Object> message = new HashMap<>();

        //Almacenar idAlumnos en optionalAlumno
        Optional<Persona> optionalAlumno = genericoDAOServicio.findByid(idAlumno);
        //Negacion de presencia de variable
        if (!optionalAlumno.isPresent()){
            //throw new BandRequestException(String.format("El id %d de alumno no existe", idAlumno));
            message.put("Success", Boolean.FALSE);
            message.put("Mensaje", String.format("El id %d de alumno no existe", idAlumno));
            return ResponseEntity.badRequest().body(message);

        }
        //Almacenar idcarrera en optionalCarrera
        Optional<Carrera> optionalCarrera = carreraDAOServicio.findByid(idCarrera);
        //Negacion de presencia de variable
        if (!optionalCarrera.isPresent()){
            //throw new BandRequestException(String.format("El id %d de alumno no existe", idCarrera));
            message.put("Success", Boolean.FALSE);
            message.put("Mensaje", String.format("El id %d de alumno no existe", idCarrera));
            return ResponseEntity.badRequest().body(message);

        }
        //Asinar a alumno de tipo persona las propiedades obtenidas de optionalAlumno(id,nombre,apellido...etc)
        Persona alumno = optionalAlumno.get();
        //Asinar a  carrera de tipo carera las propiedades obtenidas de optionalCarrera(id,nombre,dni...etc)
        Carrera carrera = optionalCarrera.get();
        //Asinar a alumno de tipo persona (es nesesario realizar el casteo a Alumno) para poder asignar las propiedades obtenidas de carrera
        ((Alumno)alumno).setCarrera(carrera);

        message.put("Success", Boolean.FALSE);
        message.put("Mensaje", genericoDAOServicio.save(alumno));
        return ResponseEntity.ok(message);



    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAlumno(@PathVariable Integer id,@RequestBody Persona alumno){
        Map<String,Object> message = new HashMap<>();
        Persona updateAlumno = null;
        Optional<Persona> optionalAlumno = genericoDAOServicio.findByid(id);
        if (!optionalAlumno.isPresent()){
            //throw new BandRequestException(String.format("El alumno con id %d no existe", id));
            message.put("Succes", Boolean.FALSE);
            message.put("Mensaje", String.format("El alumno con id %d no existe", id));
            return ResponseEntity.badRequest().body(message);
        }

        updateAlumno=optionalAlumno.get();
        updateAlumno.setNombre(alumno.getNombre());
        updateAlumno.setApellido(alumno.getApellido());
        updateAlumno.setDni(alumno.getDni());
        updateAlumno.setDireccion(alumno.getDireccion());

        message.put("Success", Boolean.TRUE);
        message.put("Datos", genericoDAOServicio.save(updateAlumno));
        return ResponseEntity.ok(message);


    }

}
