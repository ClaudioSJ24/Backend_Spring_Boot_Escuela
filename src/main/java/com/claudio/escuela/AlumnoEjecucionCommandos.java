package com.claudio.escuela;

import com.claudio.escuela.modelo.entidad.Alumno;
import com.claudio.escuela.modelo.entidad.Carrera;
import com.claudio.escuela.modelo.entidad.Persona;
import com.claudio.escuela.servicios.contratos.AlumnoDAO;
import com.claudio.escuela.servicios.contratos.CarreraDAO;
import com.claudio.escuela.servicios.contratos.PersonaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component //permite ejecutar esta clase desde la clase que contiene el metodo main EscuelaAplication.java
public class AlumnoEjecucionCommandos implements Runnable{

    @Autowired
    private CarreraDAO carreraDAOServicio;
    @Autowired
    @Qualifier("alumnoDAOImpl")//nombre del bean obtenido de la clase AlumnoDAOImpl, que va ha utilizar la variable personaDAOServicio
    private PersonaDAO personaDAOServicio;

    @Override
    public void run() {

        /*
        Paso 1
         */
        /*//Buscar carrera con id 6
        Optional<Carrera> ing = carreraDAOServicio.findByid(6);
        //mostrar todas las personas
        Iterable<Persona> alumnos = personaDAOServicio.findAll();*/
        /**
         * Castear a tipo alumno para poder utilizar el metodos de la misma clase, ya que de momento alumnos es de tipo Persona
         * alumnos recibe (setCarrera)el id obtenido de ing.get
         */
        /*

        alumnos.forEach(alumno -> ((Alumno)alumno).setCarrera(ing.get()));
        //guardar alumno en variable alumnos es decir se asocia al alumno con la carrera
        alumnos.forEach(alumno -> personaDAOServicio.save(alumno));*/



       /* //Paso 2 Ejecutando los metodos JPA de Interfax CarreraRepository
        //Se obtiene el primer alumno
        Optional<Persona> alumno1 = personaDAOServicio.findByid(1);
        //se utilizan los metodos implementados para acceder al alumno mediante el nombre y apellido, por dni y solo apellido
        Optional<Persona> personaNomApe = personaDAOServicio.buscarNombreApellido(alumno1.get().getNombre(), alumno1.get().getApellido());
        System.out.println(personaNomApe.toString());
        Optional<Persona> personaDNI = personaDAOServicio.buscarDNI(alumno1.get().getDni());
        System.out.println(personaDNI.toString());
        //Iterable retorna de 0 a n objetos
        Iterable<Persona> personaApellido = personaDAOServicio.buscarPersonaApellido(alumno1.get().getApellido());
        personaApellido.forEach(System.out::println);*/

        //Paso 3 Consultar carreras desde interfaz AlumnoRepository
        //Buscar carrera por id
        Optional<Carrera> ing = carreraDAOServicio.findByid(9);
        //Castear personaDAOServicio a AlumnosDAO para poder utilizar los metodos de la misma clase ya que es un objeto de persona y no de alumno
        Iterable<Persona> alumnoCarreras = ((AlumnoDAO) personaDAOServicio).buscarAlumnoCarrera(ing.get().getNombre());
        alumnoCarreras.forEach(System.out::println);


    }
}
