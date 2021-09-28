package com.claudio.escuela;

import com.claudio.escuela.modelo.entidad.Carrera;
import com.claudio.escuela.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

        /*Carrera ingSistemas = new Carrera(null,"Ing En Sistemas Computacionales", 55, 5);
        Carrera save = carreraDAOServicio.save(ingSistemas);
        System.out.println(save.toString());*/

    }
}
