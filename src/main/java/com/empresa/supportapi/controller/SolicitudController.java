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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/solicitudes")
@Tag(
    name = "solicitud-controller",
    description = "Operaciones de gestión de solicitudes de soporte técnico"
)
public class SolicitudController {

    private final ISolicitudService solicitudService;

    // Inyección por constructor
    public SolicitudController(ISolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    // Crear nueva solicitud con validación
    @Operation(
        summary = "Registrar una nueva solicitud",
        description = "Permite al cliente registrar una nueva solicitud de soporte técnico para ser atendida por un técnico."
    )
    @PostMapping
    public ResponseEntity<Solicitud> crearSolicitud(@Valid @RequestBody Solicitud solicitud) {
        Solicitud nuevaSolicitud = solicitudService.save(solicitud);
        return ResponseEntity.status(201).body(nuevaSolicitud);
    }

    // Listar todas las solicitudes
    @Operation(
        summary = "Listar todas las solicitudes",
        description = "Obtiene una lista con todas las solicitudes registradas en el sistema."
    )
    @GetMapping
    public ResponseEntity<List<Solicitud>> listarSolicitudes() {
        List<Solicitud> lista = solicitudService.findAll();
        if (lista.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    // Listar solicitudes por cliente
    @Operation(
        summary = "Listar solicitudes por cliente",
        description = "Devuelve todas las solicitudes registradas por un cliente específico según su ID."
    )
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Solicitud>> listarPorCliente(@PathVariable Long clienteId) {
        List<Solicitud> lista = solicitudService.findByClienteId(clienteId);
        if (lista.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lista);
    }

    // Obtener solicitud por id
    @Operation(
        summary = "Obtener una solicitud por su ID",
        description = "Devuelve los detalles de una solicitud específica según su identificador único."
    )
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
    @Operation(
        summary = "Actualizar una solicitud existente",
        description = "Permite modificar los datos de una solicitud ya registrada, identificada por su ID."
    )
    @PutMapping("/{id}")
    public ResponseEntity<Solicitud> actualizarSolicitud(
            @PathVariable Long id,
            @Valid @RequestBody Solicitud solicitud) {
        Solicitud actualizada = solicitudService.update(id, solicitud);
        if (actualizada != null) {
            return ResponseEntity.ok(actualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar solicitud
    @Operation(
        summary = "Eliminar una solicitud por su ID",
        description = "Elimina permanentemente una solicitud del sistema si existe el registro correspondiente."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSolicitud(@PathVariable Long id) {
        if (solicitudService.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        solicitudService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
