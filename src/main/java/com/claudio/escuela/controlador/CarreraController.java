package com.claudio.escuela.controlador;

import com.claudio.escuela.exception.BandRequestException;
import com.claudio.escuela.modelo.entidad.Carrera;
import com.claudio.escuela.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Deprecated //Establece el uso de la clase cuando no es nesesaria su implementación
@RestController
@RequestMapping("/carreras")

/**
 * como existen dos rutas con la misma direccion (/carreras) es necesario indicar la siguiente propiedad para
 * determinar cual ruta sera la que se ejecutara
 */
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "false")
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
    public ResponseEntity<?> updateCarrera(@PathVariable Integer id, @RequestBody Carrera carrera){
        Map<String,Object> message = new HashMap<>();
        Carrera updateCarrera = null;
        Optional<Carrera> optionalCarrera = genericoDAOServicio.findByid(id);
        if(!optionalCarrera.isPresent()){
            //throw new BandRequestException(String.format("La carrera con id %d no existe", id));
            message.put("Success", Boolean.FALSE);
            message.put("Mensaje", String.format("La carrera con id %d no existe", id));
            return ResponseEntity.badRequest().body(message);
        }
        updateCarrera=optionalCarrera.get();
        updateCarrera.setNombre(carrera.getNombre());
        updateCarrera.setNumeroMaterias(carrera.getNumeroMaterias());
        updateCarrera.setDuracionCarrera(carrera.getDuracionCarrera());

        message.put("Success", Boolean.TRUE);
        message.put("Datos", genericoDAOServicio.save(updateCarrera));

        return ResponseEntity.ok(message);

    }


}

