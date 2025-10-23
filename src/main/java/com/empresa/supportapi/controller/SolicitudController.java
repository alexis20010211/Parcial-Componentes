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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * Controlador REST para la gestión de solicitudes de soporte técnico.
 * 
 * Expone endpoints para registrar, listar, actualizar y eliminar solicitudes.
 */
@RestController
@RequestMapping("/api/solicitudes")
@Tag(name = "Solicitudes-Controller", description = "Operaciones CRUD para la gestión de solicitudes de soporte técnico")
public class SolicitudController {

    @Autowired
    private ISolicitudService solicitudService;

    // === 1️⃣ CREAR SOLICITUD ===
    @Operation(summary = "Registrar una nueva solicitud")
    @PostMapping
    public ResponseEntity<Solicitud> registrar(@Valid @RequestBody Solicitud solicitud) {
        Solicitud creada = solicitudService.registrar(solicitud);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    // === 2️⃣ LISTAR TODAS LAS SOLICITUDES ===
    @Operation(summary = "Obtener todas las solicitudes registradas")
    @GetMapping
    public ResponseEntity<List<Solicitud>> listar() {
        List<Solicitud> lista = solicitudService.listar();
        return ResponseEntity.ok(lista);
    }

    // === 3️⃣ OBTENER SOLICITUD POR ID ===
    @Operation(summary = "Obtener una solicitud por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
        Optional<Solicitud> solicitud = solicitudService.obtenerPorId(id);
        if (solicitud.isPresent()) {
            return ResponseEntity.ok(solicitud.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró la solicitud con ID: " + id);
        }
    }

    // === 4️⃣ ACTUALIZAR SOLICITUD ===
    @Operation(summary = "Actualizar una solicitud existente")
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @Valid @RequestBody Solicitud solicitud) {
        Optional<Solicitud> actualizada = solicitudService.actualizar(id, solicitud);
        if (actualizada.isPresent()) {
            return ResponseEntity.ok(actualizada.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se pudo actualizar: la solicitud con ID " + id + " no existe.");
        }
    }

    // === 5️⃣ ELIMINAR SOLICITUD ===
    @Operation(summary = "Eliminar una solicitud por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        boolean eliminado = solicitudService.eliminar(id);
        if (eliminado) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontró la solicitud con ID: " + id);
        }
    }
}
