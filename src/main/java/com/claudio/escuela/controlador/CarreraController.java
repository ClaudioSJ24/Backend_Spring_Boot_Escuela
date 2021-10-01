package com.claudio.escuela.controlador;

import com.claudio.escuela.exception.BandRequestException;
import com.claudio.escuela.modelo.entidad.Carrera;
import com.claudio.escuela.servicios.contratos.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController

@RequestMapping("/carreras")
public class CarreraController {
    private final CarreraDAO carreraDAOServicio;

    @Autowired
    public CarreraController(CarreraDAO carreraDAOServicio) {
        this.carreraDAOServicio = carreraDAOServicio;
    }

    /**
     * Al ejecutar este metodo se produce una exception, esto se debe a que en la clase Carreras se tienen dos instancias:
     * 1)Alumnos
     * 2)Profesor
     * Por lo tanto es nesesario aplicar el decorador @JsonIgnoreProperties({"carreras"}) y @JsonIgnoreProperties({"carrera"})
     * a cada una de ellas respectivamente para tener una consulta optima
     */
    @GetMapping
    public List<Carrera> getAll(){
        List<Carrera> carreras = (List<Carrera>) carreraDAOServicio.findAll();

        if (carreras.isEmpty()){
            throw new BandRequestException("No hay carreras ");
        }
        return carreras;
    }
}

