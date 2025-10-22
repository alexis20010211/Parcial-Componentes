package com.empresa.supportapi.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Maneja errores de validación @Valid
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> manejarValidacion(
            MethodArgumentNotValidException ex, HttpServletRequest request) {

        Map<String, Object> response = new HashMap<>();
        Map<String, String> detalles = new HashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            detalles.put(error.getField(), error.getDefaultMessage());
        }

        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", "Error de validación");
        response.put("detalles", detalles);
        response.put("path", request.getRequestURI());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // Maneja cuando un recurso no se encuentra
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String, Object>> manejarNoEncontrado(
            NoSuchElementException ex, HttpServletRequest request) {

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.NOT_FOUND.value());
        response.put("error", "Recurso no encontrado");
        response.put("detalles", ex.getMessage());
        response.put("path", request.getRequestURI());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // Maneja excepciones generales
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> manejarExcepcionGeneral(
            Exception ex, HttpServletRequest request) {

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.put("error", "Error interno del servidor");
        response.put("detalles", ex.getMessage());
        response.put("path", request.getRequestURI());

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
