package com.claudio.escuela;

import com.claudio.escuela.modelo.entidad.Carrera;
import com.claudio.escuela.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
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
/*

//Ejecutando crud
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
*/

        /* Carrera ingSistemas = new Carrera(null,"Ing En Sistemas Computacionales", 55, 5);
        Carrera save = carreraDAOServicio.save(ingSistemas);
        System.out.println(save.toString());*/


        //Ejecutar crud y consultas JPQL Y JPA

        /*Carrera ingIndustrial = new Carrera(null, "Ing. Industrial", 40, 3);
        Carrera ingCivil = new Carrera(null, "Ing. Civil", 50, 4);
        Carrera ingAmbiental = new Carrera(null, "Ing. ambiental",35, 5);
        Carrera ingMecatronica = new Carrera(null, "Ing. Mecatronica", 53, 4);
        Carrera licContaduria = new Carrera(null, "Lic. Contaduria", 45, 3);
        Carrera licDerecho = new Carrera(null, "Lic. Derecho", 49, 4);
        Carrera licAdministracion = new Carrera(null, "Lic. Administracion", 56, 5);
        Carrera arquitectura = new Carrera(null, "Arquitecto", 40, 3);

        carreraDAOServicio.save(ingAmbiental);
        carreraDAOServicio.save(ingCivil);
        carreraDAOServicio.save(ingIndustrial);
        carreraDAOServicio.save(ingMecatronica);
        carreraDAOServicio.save(licAdministracion);
        carreraDAOServicio.save(licContaduria);
        carreraDAOServicio.save(licDerecho);
        carreraDAOServicio.save(arquitectura);*/

        //Busca la carrera con el nombre exacto tal como esta escrito
        List<Carrera> busCarrera = (List<Carrera>) carreraDAOServicio.findCarrerasByNombreContains("Industrial");
        for (Carrera carrera : busCarrera) {
            System.out.println(carrera.toString());

        }

        //Innora la forma en que esta escrita la carrera
        List<Carrera> carreraIgnoreC1= (List<Carrera>) carreraDAOServicio.findCarrerasByNombreContainsIgnoreCase("aquitecto");
        carreraIgnoreC1.forEach(System.out::println);

        List<Carrera> carreraIgnireC2= (List<Carrera>) carreraDAOServicio.findCarrerasByNombreContainsIgnoreCase("ArQUITECTO");
        carreraIgnireC2.forEach(System.out::println);

        //Busca la carrera por la duracion de años
        List<Carrera> busCarreraA = (List<Carrera>) carreraDAOServicio.findCarrerasByDuracionCarreraAfter(5);
        busCarreraA.forEach(System.out::println);


    }
}
