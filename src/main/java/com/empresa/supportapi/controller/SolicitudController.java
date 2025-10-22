package com.empresa.supportapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.supportapi.Interfaces.ISolicitudService;
import com.empresa.supportapi.model.Solicitud;

import jakarta.validation.Valid;

/**
 * Controlador REST para la gestión de solicitudes de soporte técnico.
 * 
 * Expone endpoints para registrar, listar, actualizar y eliminar solicitudes.
 * Cumple con el modelo REST y aplica validaciones con @Valid.
 */
@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {

    @Autowired
    private ISolicitudService solicitudService;

    /**
     * Obtiene la lista completa de solicitudes registradas.
     *
     * @return lista de solicitudes (200 OK)
     */
    @GetMapping
    public ResponseEntity<List<Solicitud>> listar() {
        List<Solicitud> lista = solicitudService.listar();
        return ResponseEntity.ok(lista);
    }

    /**
     * Busca una solicitud por su ID.
     *
     * @param id identificador de la solicitud
     * @return solicitud encontrada (200 OK) o error 404 si no existe
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
        Optional<Solicitud> solicitud = solicitudService.obtenerPorId(id);
        if (solicitud.isPresent()) {
            return ResponseEntity.ok(solicitud.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(" No se encontró la solicitud con ID: " + id);
        }
    }

    /**
     * Registra una nueva solicitud en el sistema.
     *
     * @param solicitud objeto recibido en el cuerpo de la petición
     * @return solicitud creada (201 Created)
     */
    @PostMapping
    public ResponseEntity<Solicitud> registrar(@Valid @RequestBody Solicitud solicitud) {
        Solicitud creada = solicitudService.registrar(solicitud);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    /**
     * Actualiza los datos de una solicitud existente.
     *
     * @param id identificador de la solicitud
     * @param solicitud objeto con los nuevos datos
     * @return solicitud actualizada (200 OK) o 404 si no existe
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @Valid @RequestBody Solicitud solicitud) {
        Optional<Solicitud> actualizada = solicitudService.actualizar(id, solicitud);
        if (actualizada.isPresent()) {
            return ResponseEntity.ok(actualizada.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(" No se pudo actualizar: la solicitud con ID " + id + " no existe.");
        }
    }

    /**
     * Elimina una solicitud existente.
     *
     * @param id identificador de la solicitud
     * @return 204 No Content si se eliminó, 404 si no existe
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        boolean eliminado = solicitudService.eliminar(id);
        if (eliminado) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(" No se encontró la solicitud con ID: " + id);
        }
    }
}
