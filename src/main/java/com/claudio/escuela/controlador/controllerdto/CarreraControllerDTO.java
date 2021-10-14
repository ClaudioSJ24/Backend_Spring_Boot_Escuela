package com.claudio.escuela.controlador.controllerdto;

import com.claudio.escuela.modelo.dto.CarreraDTO;
import com.claudio.escuela.modelo.entidad.Carrera;
import com.claudio.escuela.modelo.mapper.CarreraMapper;
import com.claudio.escuela.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carreras")
/*
 * como existen dos rutas con la misma direccion (/carreras) es necesario indicar la siguiente propiedad para
 * determinar cual ruta sera la que se ejecutara
 */

@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "true")
public class CarreraControllerDTO {
    @Autowired
    private CarreraDAO carreraDAO;

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        Map<String, Object> message = new HashMap<>();
        List<Carrera> carreras = (List<Carrera>) carreraDAO.findAll();
        /*
         * Los metodos aplicados a la variable carreras permiten realizar un mapeo de los datos de la clase CarreraMapper para poder
         * obtener una coleccion de datos en un lista de las propiedades de la misma y convertirlos a una lista del tipo CarrerasDTO
         */

        List<CarreraDTO> carreraDTOS = carreras
                                        .stream()
                                        .map(CarreraMapper::mapCarreraDTO)//clase::metodo
                                        .collect(Collectors.toList());

        message.put("Datos", carreraDTOS);
        message.put("Success", Boolean.TRUE);
        return ResponseEntity.ok(message);


    }

}
