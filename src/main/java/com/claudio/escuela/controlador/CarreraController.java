package com.claudio.escuela.controlador;

import com.claudio.escuela.exception.BandRequestException;
import com.claudio.escuela.modelo.entidad.Carrera;
import com.claudio.escuela.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

@RequestMapping("/carreras")
public class CarreraController extends GenericController<Carrera,CarreraDAO> {
   // private final CarreraDAO carreraDAOServicio;


    @Autowired
    public CarreraController(CarreraDAO genericoDAOServicio) {
        super(genericoDAOServicio);
        nombreEntidad = "Carreras";
    }

    /**
     * Al ejecutar este metodo se produce una exception, esto se debe a que en la clase Carreras se tienen dos instancias:
     * 1)Alumnos
     * 2)Profesor
     * Por lo tanto es nesesario aplicar el decorador @JsonIgnoreProperties({"carreras"}) y @JsonIgnoreProperties({"carrera"})
     * a cada una de ellas respectivamente para tener una consulta optima
     */


    @PutMapping("/update/{id}")
    //Cuando los parametros son iguales no es nesesario establecer la propiedad value en @PathVariable
    //Es neseasario establecer la propiedad @RequestBody a un objeto que se utilice mediante Put
    public Carrera updateCarrera(@PathVariable Integer id,@RequestBody Carrera carrera){
        Carrera updateCarrera = null;
        Optional<Carrera> optionalCarrera = genericoDAOServicio.findByid(id);
        if(!optionalCarrera.isPresent()){
            throw new BandRequestException(String.format("La carrera con id %d no existe", id));
        }
        updateCarrera=optionalCarrera.get();
        updateCarrera.setNombre(carrera.getNombre());
        updateCarrera.setNumeroMaterias(carrera.getNumeroMaterias());
        updateCarrera.setDuracionCarrera(carrera.getDuracionCarrera());

        return genericoDAOServicio.save(updateCarrera);

    }
   /* @GetMapping("/getAll")
    public List<Carrera> getAll(){
        List<Carrera> carreras = (List<Carrera>) carreraDAOServicio.findAll();

        if (carreras.isEmpty()){
            throw new BandRequestException("No hay carreras ");
        }
        return carreras;
    }
    @PostMapping("/save")
    //Es neseasario establecer la propiedad @RequestBody a un objeto que se utilice mediante Post
    public Carrera saveCarrera(@RequestBody Carrera carrera){
        if(carrera.getDuracionCarrera() < 0){

            throw new BandRequestException(String.format("La cantidad de años %d no es valido", carrera.getDuracionCarrera()));
        }

        if(carrera.getNumeroMaterias() < 0){
            throw new BandRequestException(String.format("El numero de materias %d no es valido", carrera.getNumeroMaterias()));
        }
        return genericoDAOServicio.save(carrera);
    }

    @GetMapping("/id/{codigo}")// variable que buscara via url
    //Cuando los parametros no son igualesv(codigo es diferente id)  es nesesario establecer la propiedad value en @PathVariable
    public Carrera getById(@PathVariable(value = "codigo", required = false) Integer id){

        Optional<Carrera> optionalCarrera = genericoDAOServicio.findByid(id);
        if(!optionalCarrera.isPresent()){
            throw new BandRequestException(String.format("La carrera con id %d no existe", id));
        }
        return  optionalCarrera.get();

    }

    @DeleteMapping("/delete/{id}")
    public void deleteCarrera(@PathVariable Integer id){

        Optional<Carrera> buscarIdCarrera = genericoDAOServicio.findByid(id);
        if(!buscarIdCarrera.isPresent()){

            throw new BandRequestException(String.format("La carrera con id %d no existe", id));
        }

        genericoDAOServicio.deleteById(id);


    }

    */

}

