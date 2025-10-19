package com.empresa.supportapi.controller;

import com.empresa.supportapi.model.Solicitud;
import com.empresa.supportapi.service.SolicitudService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    // GET /solicitudes → listar todas
    @GetMapping
    public ResponseEntity<List<Solicitud>> listar() {
        List<Solicitud> lista = solicitudService.listar();
        return ResponseEntity.ok(lista);
    }

    // GET /solicitudes/{id} → obtener por ID
    @GetMapping("/{id}")
    public ResponseEntity<Solicitud> obtenerPorId(@PathVariable Long id) {
        Optional<Solicitud> solicitud = solicitudService.obtenerPorId(id);
        return solicitud.map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }

    // POST /solicitudes → crear nueva solicitud
    @PostMapping
    public ResponseEntity<Solicitud> registrar(@Valid @RequestBody Solicitud solicitud) {
        Solicitud creada = solicitudService.registrar(solicitud);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    // PUT /solicitudes/{id} → actualizar solicitud existente
    @PutMapping("/{id}")
    public ResponseEntity<Solicitud> actualizar(@PathVariable Long id, @Valid @RequestBody Solicitud solicitud) {
        Optional<Solicitud> actualizada = solicitudService.actualizar(id, solicitud);
        return actualizada.map(ResponseEntity::ok)
                          .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /solicitudes/{id} → eliminar solicitud
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = solicitudService.eliminar(id);
        return eliminado ? ResponseEntity.noContent().build()
                         : ResponseEntity.notFound().build();
    }
}
