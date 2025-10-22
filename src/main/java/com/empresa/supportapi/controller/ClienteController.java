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

import jakarta.validation.Valid;

/**
 * Controlador REST para gestionar las operaciones CRUD de los clientes.
 * Cumple con la separación de capas y las buenas prácticas de arquitectura.
 */
@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    /** 
     * Obtiene la lista completa de clientes. 
     */
    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listar();
    }

    /** 
     * Obtiene un cliente específico por su ID. 
     */
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtener(@PathVariable Long id) {
        return clienteService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /** 
     * Registra un nuevo cliente con validación de datos. 
     */
    @PostMapping
    public ResponseEntity<Cliente> registrar(@Valid @RequestBody Cliente cliente) {
        Cliente nuevo = clienteService.registrar(cliente);
        return ResponseEntity.ok(nuevo);
    }

    /** 
     * Actualiza un cliente existente. 
     */
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        try {
            Cliente actualizado = clienteService.actualizar(id, cliente);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /** 
     * Elimina un cliente por su ID. 
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        clienteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
