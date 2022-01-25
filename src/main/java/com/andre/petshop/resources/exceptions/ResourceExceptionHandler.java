package com.andre.petshop.resources.exceptions;

import com.andre.petshop.service.exceptions.DataIntegrityException;
import com.andre.petshop.service.exceptions.ObjetoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjetoNaoEncontradoException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjetoNaoEncontradoException err, HttpServletRequest request) {

        StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), err.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> objectNotFound(DataIntegrityException err, HttpServletRequest request) {

        StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), err.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
