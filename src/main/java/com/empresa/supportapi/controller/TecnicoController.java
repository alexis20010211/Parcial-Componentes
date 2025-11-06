package com.empresa.supportapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.supportapi.model.Tecnico;
import com.empresa.supportapi.service.TecnicoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * Controlador para el rol TÉCNICO.
 * Este controlador solo permite al técnico consultar y actualizar su propio perfil.
 * No puede crear, eliminar ni ver otros técnicos.
 */
@RestController
@RequestMapping("/api/tecnico")
@Tag(name = "Técnico", description = "Operaciones del rol Técnico (perfil propio)")
public class TecnicoController {

    private final TecnicoService tecnicoService;

    public TecnicoController(TecnicoService tecnicoService) {
        this.tecnicoService = tecnicoService;
    }

    // === Obtener su propio perfil ===
    @Operation(summary = "Obtener los datos del técnico por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<Tecnico> obtenerMiPerfil(@PathVariable Long id) {
        Tecnico tecnico = tecnicoService.obtenerPorId(id);
        if (tecnico == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tecnico);
    }

    // === Actualizar su perfil ===
    @Operation(summary = "Actualizar los datos del técnico (solo su cuenta)")
    @PutMapping("/{id}")
    public ResponseEntity<Tecnico> actualizarPerfil(
            @PathVariable Long id,
            @Valid @RequestBody Tecnico tecnico) {
        
        Tecnico actualizado = tecnicoService.actualizar(id, tecnico);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }



}
