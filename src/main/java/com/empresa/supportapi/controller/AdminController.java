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

import com.empresa.supportapi.model.Admin;
import com.empresa.supportapi.service.AdminService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/admi")
@Tag(
    name = "Administrador",
    description = "Operaciones del rol Administrador: gestión de administradores del sistema"
)
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @Operation(
        summary = "Listar todos los administradores",
        description = "Obtiene una lista completa de los administradores registrados en el sistema."
    )
    @GetMapping
    public List<Admin> listarAdmins() {
        return adminService.listarAdmins();
    }

    @Operation(
        summary = "Obtener administrador por ID",
        description = "Devuelve los datos del administrador correspondiente al ID proporcionado."
    )
    @GetMapping("/{id}")
    public ResponseEntity<Admin> obtenerPorId(@PathVariable Long id) {
        return adminService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
        summary = "Registrar un nuevo administrador",
        description = "Permite crear un nuevo administrador con los datos proporcionados en el cuerpo de la solicitud."
    )
    @PostMapping
    public Admin registrar(@RequestBody Admin admin) {
        return adminService.registrar(admin);
    }

    @Operation(
        summary = "Actualizar los datos de un administrador",
        description = "Permite modificar los datos de un administrador existente identificado por su ID."
    )
    @PutMapping("/{id}")
    public ResponseEntity<Admin> actualizar(@PathVariable Long id, @RequestBody Admin admin) {
        Admin actualizado = adminService.actualizar(id, admin);
        return (actualizado != null)
                ? ResponseEntity.ok(actualizado)
                : ResponseEntity.notFound().build();
    }

    @Operation(
        summary = "Eliminar un administrador por su ID",
        description = "Elimina permanentemente el registro de un administrador existente según su identificador."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        adminService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
