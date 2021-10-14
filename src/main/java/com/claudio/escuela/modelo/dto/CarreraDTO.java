package com.claudio.escuela.modelo.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.criteria.CriteriaBuilder;

public class CarreraDTO {

    private Integer idDTO;
    private String nombreDTO;
    private Integer numeroMateriasDTO;
    private Integer duracionCarreraDTO;

    public CarreraDTO() {

    }

    public Integer getIdDTO() {
        return idDTO;
    }

    public void setIdDTO(Integer idDTO) {
        this.idDTO = idDTO;
    }

    public String getNombreDTO() {
        return nombreDTO;
    }

    public void setNombreDTO(String nombreDTO) {
        this.nombreDTO = nombreDTO;
    }

    public Integer getNumeroMateriasDTO() {
        return numeroMateriasDTO;
    }

    public void setNumeroMateriasDTO(Integer numeroMateriasDTO) {
        this.numeroMateriasDTO = numeroMateriasDTO;
    }

    public Integer getDuracionCarreraDTO() {
        return duracionCarreraDTO;
    }

    public void setDuracionCarreraDTO(Integer duracionCarreraDTO) {
        this.duracionCarreraDTO = duracionCarreraDTO;
    }
}
