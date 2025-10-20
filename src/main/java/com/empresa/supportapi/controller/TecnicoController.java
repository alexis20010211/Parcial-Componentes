package com.empresa.supportapi.controller;

import java.util.List;

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

import com.empresa.supportapi.model.Tecnico;
import com.empresa.supportapi.service.TecnicoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tecnicos")
@Tag(name = "Técnicos-Controller", description = "Operaciones CRUD para técnicos")
public class TecnicoController {

    private final TecnicoService tecnicoService;

    public TecnicoController(TecnicoService tecnicoService) {
        this.tecnicoService = tecnicoService;
    }

    @Operation(summary = "Registrar un nuevo técnico")
    @PostMapping
    public ResponseEntity<Tecnico> crearTecnico(@Valid @RequestBody Tecnico tecnico) {
        Tecnico nuevo = tecnicoService.crearTecnico(tecnico);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @Operation(summary = "Obtener todos los técnicos")
    @GetMapping
    public ResponseEntity<List<Tecnico>> obtenerTodos() {
        return ResponseEntity.ok(tecnicoService.obtenerTodos());
    }

    @Operation(summary = "Obtener técnico por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Tecnico> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tecnicoService.obtenerPorId(id));
    }

    @Operation(summary = "Actualizar un técnico existente")
    @PutMapping("/{id}")
    public ResponseEntity<Tecnico> actualizar(@PathVariable Long id, @Valid @RequestBody Tecnico tecnico) {
        return ResponseEntity.ok(tecnicoService.actualizar(id, tecnico));
    }

    @Operation(summary = "Eliminar un técnico")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        tecnicoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
