package com.empresa.supportapi.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.supportapi.model.Cliente;
import com.empresa.supportapi.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * Controlador REST para gestionar las operaciones CRUD de los clientes.
 * Aplica validaciones y sigue el modelo REST.
 */
@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
@Tag(name = "Clientes-Controller", description = "Operaciones CRUD para la gestión de clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // === 1️⃣ REGISTRAR CLIENTE ===
    @Operation(summary = "Registrar un nuevo cliente")
    @PostMapping
    public ResponseEntity<Cliente> registrar(@Valid @RequestBody Cliente cliente) {
        Cliente nuevo = clienteService.registrar(cliente);
        return ResponseEntity.ok(nuevo);
    }

    // === 2️⃣ OBTENER TODOS LOS CLIENTES ===
    @Operation(summary = "Obtener la lista completa de clientes")
    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listar();
    }

    // === 3️⃣ OBTENER CLIENTE POR ID ===
    @Operation(summary = "Obtener un cliente por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtener(@PathVariable Long id) {
        return clienteService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // === 4️ ACTUALIZAR CLIENTE ===
    @Operation(summary = "Actualizar los datos de un cliente existente")
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        try {
            Cliente actualizado = clienteService.actualizar(id, cliente);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // === 5️ ELIMINAR CLIENTE ===
    @Operation(summary = "Eliminar un cliente por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        clienteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
