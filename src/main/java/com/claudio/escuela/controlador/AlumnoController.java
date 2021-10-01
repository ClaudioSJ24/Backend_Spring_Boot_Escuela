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

    //Se establece como una variable final de PersonaDao para que se inicialize mediante el constructor y pueda ser utilizada libremente
    private final PersonaDAO alumnoDAOServicio;
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
        Optional<Persona> optionalAlumno = alumnoDAOServicio.findByid(idAlumno);
        if (!optionalAlumno.isPresent()){
            throw new BandRequestException(String.format("El id %d de alumno no existe", idAlumno));

        }
        Optional<Carrera> optionalCarrera = carreraDAOServicio.findByid(idCarrera);
        if (!optionalCarrera.isPresent()){
            throw new BandRequestException(String.format("El id %d de alumno no existe", idCarrera));

        }
        Persona alumno = optionalAlumno.get();
        Carrera carreraA = optionalCarrera.get();
        ((Alumno)alumno).setCarrera(carreraA);

        return alumnoDAOServicio.save(alumno);

    }

}
