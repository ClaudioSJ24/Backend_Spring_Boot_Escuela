package com.claudio.escuela.controlador;

import com.claudio.escuela.exception.BandRequestException;
import com.claudio.escuela.servicios.contratos.GenericoDAO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class GenericController<Entidad,Servicio extends GenericoDAO<Entidad>> {
    protected final Servicio genericoDAOServicio;
    protected String nombreEntidad;

    public GenericController(Servicio genericoDAOServicio) {
        this.genericoDAOServicio = genericoDAOServicio;

    }
    @GetMapping("getall")
    public List<Entidad> getAllEntidad(){
        List<Entidad> entidades = (List<Entidad>) genericoDAOServicio.findAll();
        if(entidades.isEmpty()){
            throw new BandRequestException(String.format("No existen entidades de %s ",nombreEntidad));
        }
        return entidades;
    }
   @GetMapping("id/{id}")
    public Entidad findByIdEntidad(@PathVariable Integer id){
        Optional<Entidad> optionalGenerico = genericoDAOServicio.findByid(id);
        if(!optionalGenerico.isPresent()){
            throw new BandRequestException(String.format("El id %d de %s no existe", id,nombreEntidad));
        }
        return optionalGenerico.get();

    }
    @PostMapping("save")
    public Entidad saveEntidad(@RequestBody Entidad entidad){

        return genericoDAOServicio.save(entidad);


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
