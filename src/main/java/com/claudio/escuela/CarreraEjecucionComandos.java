package com.claudio.escuela;

import com.claudio.escuela.modelo.entidad.Carrera;
import com.claudio.escuela.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * //clase que permitira probar los comandos de los servicios a utilizar en el
 * los paquetes:
 * Repositorios//CarreraRepository(interfaz)->Acceso a metodos de la herencia de CrudRepository
 * contratos//CarreraDAO(interfax)->establecen los metodos a implementar para el crud de la clase carreras
 * implementaciones//carreraDAOImpl(clase)->ejecuta los metodos  de la interfax carreraDAO mediante una entidad de CarreraRepository
 */
@Component //Establece la clase como un bean para que pueda utilizarce desde spring
public class CarreraEjecucionComandos implements CommandLineRunner {

    @Autowired//Permite la injeccion y persisntencia de dependencias
    private CarreraDAO carreraDAOServicio;
    @Override
    public void run(String... args) throws Exception {

       /* Carrera ingSistemas = new Carrera(null,"Ing En Sistemas Computacionales", 55, 5);
        Carrera save = carreraDAOServicio.save(ingSistemas);
        System.out.println(save.toString());*/

        Carrera carrera=null;
        Optional<Carrera> optionalCarrera = carreraDAOServicio.findByid(3);


        if(optionalCarrera.isPresent()){
            carrera = optionalCarrera.get();
            System.out.println(carrera.toString());
        }else{
            System.out.println("Carrera no encontrada");
        }

        carrera.setNumeroMaterias(62);
        carrera.setDuracionCarrera(7);

        carreraDAOServicio.save(carrera);

        System.out.println(carreraDAOServicio.findByid(3).orElse(new Carrera()).toString());

        carreraDAOServicio.deleteById(3);
        System.out.println(carreraDAOServicio.findByid(3).orElse(new Carrera()).toString());


    }
}
