package com.claudio.escuela.exception;
//clase para controlar excepciones
public class BandRequestException extends RuntimeException {

    //constructor
    public BandRequestException(String message) {
        super(message);
    }
}
