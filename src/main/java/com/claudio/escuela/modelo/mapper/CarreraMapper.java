package com.claudio.escuela.modelo.mapper;

import com.claudio.escuela.modelo.dto.CarreraDTO;
import com.claudio.escuela.modelo.entidad.Carrera;

public class CarreraMapper {

    public static CarreraDTO mapCarreraDTO(Carrera carrera){
        CarreraDTO carreraDTO = new CarreraDTO();
        carreraDTO.setIdDTO(carrera.getId());
        carreraDTO.setNombreDTO(carrera.getNombre());
        carreraDTO.setDuracionCarreraDTO(carrera.getDuracionCarrera());
        carreraDTO.setNumeroMateriasDTO(carrera.getNumeroMaterias());
        return carreraDTO;
    }


}
