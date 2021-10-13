package com.claudio.escuela.controlador;

import com.claudio.escuela.exception.BandRequestException;
import com.claudio.escuela.servicios.contratos.GenericoDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GenericController<Entidad,Servicio extends GenericoDAO<Entidad>> {
    protected final Servicio genericoDAOServicio;
    protected String nombreEntidad;

    public GenericController(Servicio genericoDAOServicio) {
        this.genericoDAOServicio = genericoDAOServicio;

    }
    @GetMapping("/getall")
    public ResponseEntity<?> getAllEntidad(){
        Map<String,Object> message = new HashMap<>();
        List<Entidad> entidades = (List<Entidad>) genericoDAOServicio.findAll();
        if(entidades.isEmpty()){
            //throw new BandRequestException(String.format("No existen entidades de %s ",nombreEntidad));
            message.put("success", Boolean.FALSE);
            message.put("mensaje", String.format("No existen %s", nombreEntidad));
            return ResponseEntity.badRequest().body(message);
        }
        message.put("success", Boolean.TRUE);
        message.put("Datos", entidades);
        return ResponseEntity.ok(message);
    }
   @GetMapping("/id/{id}")
    public ResponseEntity<?> findByIdEntidad(@PathVariable Integer id){
        Map<String, Object> message = new HashMap<>();
        Optional<Entidad> optionalGenerico = genericoDAOServicio.findByid(id);
        if(!optionalGenerico.isPresent()){
            //throw new BandRequestException(String.format("El id %d de %s no existe", id,nombreEntidad));
            message.put("Success", Boolean.FALSE);
            message.put("Success", String.format("No existe el %d en la base de datos", id));
            return ResponseEntity.badRequest().body(message);
        }

        message.put("Success", Boolean.TRUE);
        message.put("Datos", optionalGenerico.get());
        return ResponseEntity.ok(message);

    }
    @PostMapping("/save")
    public ResponseEntity<?> saveEntidad(@RequestBody Entidad entidad){
        Map<String, Object> message = new HashMap<>();
        message.put("Success", Boolean.TRUE);
        message.put("Datos", genericoDAOServicio.save(entidad));
        return ResponseEntity.ok(message);


    }


    @DeleteMapping("/delete/{id}")
    public void deleteEntidad(@PathVariable Integer id){

        Optional<Entidad> optionalGenerico = genericoDAOServicio.findByid(id);
        if(!optionalGenerico.isPresent()){
            throw new BandRequestException(String.format("El id %d de %s no existe", id,nombreEntidad));
        }
        genericoDAOServicio.deleteById(id);
    }

}
