package com.empresa.supportapi.controller;

import java.util.List;

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

@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {

    private final ISolicitudService solicitudService;

    // Inyección por constructor
    public SolicitudController(ISolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    // Crear nueva solicitud con validación
    @PostMapping
    public ResponseEntity<Solicitud> crearSolicitud(@Valid @RequestBody Solicitud solicitud) {
        Solicitud nuevaSolicitud = solicitudService.save(solicitud);
        return ResponseEntity.status(201).body(nuevaSolicitud);
    }

    // Listar todas las solicitudes
    @GetMapping
    public ResponseEntity<List<Solicitud>> listarSolicitudes() {
        List<Solicitud> lista = solicitudService.findAll();
        if (lista.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    // Listar solicitudes por cliente
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Solicitud>> listarPorCliente(@PathVariable Long clienteId) {
        List<Solicitud> lista = solicitudService.findByClienteId(clienteId);
        if (lista.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    // Obtener solicitud por id
    @GetMapping("/{id}")
    public ResponseEntity<Solicitud> obtenerSolicitud(@PathVariable Long id) {
        Solicitud solicitud = solicitudService.findById(id);
        if (solicitud != null) {
            return ResponseEntity.ok(solicitud);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Actualizar solicitud
    @PutMapping("/{id}")
    public ResponseEntity<Solicitud> actualizarSolicitud(@PathVariable Long id, @Valid @RequestBody Solicitud solicitud) {
        Solicitud actualizada = solicitudService.update(id, solicitud);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar solicitud
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSolicitud(@PathVariable Long id) {
        if (solicitudService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        solicitudService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
