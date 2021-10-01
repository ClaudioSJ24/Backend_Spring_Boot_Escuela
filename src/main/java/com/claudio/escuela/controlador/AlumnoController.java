package com.claudio.escuela.controlador;

import com.claudio.escuela.exception.BandRequestException;
import com.claudio.escuela.modelo.entidad.Alumno;
import com.claudio.escuela.modelo.entidad.Carrera;
import com.claudio.escuela.modelo.entidad.Persona;
import com.claudio.escuela.servicios.contratos.CarreraDAO;
import com.claudio.escuela.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    //Se establece como una variable final de PersonaDao para que se inicialize mediante el constructor y poder utilizar sus propiedades(variables y metodos)
    private final PersonaDAO alumnoDAOServicio;
    //Se establece como una variable final de PersonaDao para que se inicialize mediante el constructor y pueda ser utilizada libremente poder utilizar sus propiedades(variables y metodos)
    //y asi poder asignar una carrera a alumno
    private final CarreraDAO carreraDAOServicio;

    @Autowired
    //"alumnoDAOImple" es la clase de donde se obtendran las personasDao de tipo alumno
    public AlumnoController(@Qualifier("alumnoDAOImpl") PersonaDAO alumnoDAOServicio, CarreraDAO carreraDAOServicio) {
        this.alumnoDAOServicio = alumnoDAOServicio;
        this.carreraDAOServicio = carreraDAOServicio;
    }
    @GetMapping("/id/{codigo}")
    public Persona getAlumnoById(@PathVariable(value = "codigo", required = false) Integer id){
        Optional<Persona> optionalAlumno = alumnoDAOServicio.findByid(id);
        if (!optionalAlumno.isPresent()){
            throw new BandRequestException(String.format("El id %d no existe", id));
        }
        return optionalAlumno.get();
    }
    @GetMapping("/getAll")
    public  List<Persona> getAllAlumnos(){

        List<Persona> alumnos = (List<Persona>) alumnoDAOServicio.findAll();
        if (alumnos.isEmpty()){
            throw new BandRequestException("No hay alumnos¡¡¡");
        }
        return alumnos;

    }
    @PostMapping("/save")
    public Persona saveAlumno(@RequestBody Persona alumno){
        return alumnoDAOServicio.save(alumno);
    }

    @PutMapping("/update/{id}")
    public Persona updateAlumno(@PathVariable Integer id,@RequestBody Persona alumno){

        Persona updateAlumno = null;
        Optional<Persona> optionalAlumno = alumnoDAOServicio.findByid(id);
        if (!optionalAlumno.isPresent()){
            throw new BandRequestException(String.format("El alumno con id %d no existe", id));
        }

        updateAlumno=optionalAlumno.get();
        updateAlumno.setNombre(alumno.getNombre());
        updateAlumno.setApellido(alumno.getApellido());
        updateAlumno.setDni(alumno.getDni());
        updateAlumno.setDireccion(alumno.getDireccion());

        return alumnoDAOServicio.save(updateAlumno);


    }
    @DeleteMapping("delete/{id}")
    public void deleteAlumno(@PathVariable Integer id){
        Optional<Persona> optionalAlumno = alumnoDAOServicio.findByid(id);
        if (!optionalAlumno.isPresent()){
            throw new BandRequestException(String.format("El id %d no existe", id));
        }
        alumnoDAOServicio.deleteById(id);
    }


    @PutMapping("/{idAlumno}/carrera/{idCarrera}")
    public Persona addCarreraAlumno(@PathVariable Integer idAlumno, @PathVariable Integer idCarrera){
        //Almacenar idAlumnos en optionalAlumno
        Optional<Persona> optionalAlumno = alumnoDAOServicio.findByid(idAlumno);
        //Negacion de presencia de variable
        if (!optionalAlumno.isPresent()){
            throw new BandRequestException(String.format("El id %d de alumno no existe", idAlumno));

        }
        //Almacenar idcarrera en optionalCarrera
        Optional<Carrera> optionalCarrera = carreraDAOServicio.findByid(idCarrera);
        //Negacion de presencia de variable
        if (!optionalCarrera.isPresent()){
            throw new BandRequestException(String.format("El id %d de alumno no existe", idCarrera));

        }
        //Asinar a alumno de tipo persona las propiedades obtenidas de optionalAlumno(id,nombre,apellido...etc)
        Persona alumno = optionalAlumno.get();
        //Asinar a  carrera de tipo carera las propiedades obtenidas de optionalCarrera(id,nombre,dni...etc)
        Carrera carrera = optionalCarrera.get();
        //Asinar a alumno de tipo persona (es nesesario realizar el casteo a Alumno) para poder asignar las propiedades obtenidas de carrera
        ((Alumno)alumno).setCarrera(carrera);

        return alumnoDAOServicio.save(alumno);

    }

}
