package com.empresa.supportapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.supportapi.dto.ClienteDTO;
import com.empresa.supportapi.mapper.ClienteMapper;
import com.empresa.supportapi.model.Cliente;
import com.empresa.supportapi.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * Controlador para el rol CLIENTE.
 * Cada cliente solo puede consultar y actualizar su propio perfil.
 * No puede ver ni modificar otros clientes.
 */
@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
@Tag(name = "Cliente", description = "Operaciones del cliente (perfil propio)")
public class ClienteController {

    private final ClienteService clienteService;
    private final ClienteMapper clienteMapper;

    public ClienteController(ClienteService clienteService, ClienteMapper clienteMapper) {
        this.clienteService = clienteService;
        this.clienteMapper = clienteMapper;
    }

    // === Obtener su propio perfil ===
    @Operation(summary = "Obtener los datos del cliente por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obtenerMiPerfil(@PathVariable Long id) {
        return clienteService.obtenerPorId(id)
                .map(cliente -> ResponseEntity.ok(clienteMapper.toDTO(cliente)))
                .orElse(ResponseEntity.notFound().build());
    }

    //TODO: ENDPOINT NUEVO PARA OBTENER SOLICITUDES PENDIENTES DEL CLIENTE
    // url -> /{id}/solicitudes/{status} || /{id}/solicitudes?status='PENDIENTES'

    // === Actualizar su propio perfil ===
    @Operation(summary = "Actualizar los datos del cliente (solo su cuenta)")
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> actualizarPerfil(
            @PathVariable Long id,
            @Valid @RequestBody ClienteDTO clienteDTO) {

        try {
            Cliente cliente = clienteMapper.toEntity(clienteDTO);
            Cliente actualizado = clienteService.actualizar(id, cliente);
            return ResponseEntity.ok(clienteMapper.toDTO(actualizado));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // === Eliminar su propia cuenta (opcional) ===
    @Operation(summary = "Eliminar la cuenta del cliente (solo su propia cuenta)")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCuenta(@PathVariable Long id) {
        clienteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
