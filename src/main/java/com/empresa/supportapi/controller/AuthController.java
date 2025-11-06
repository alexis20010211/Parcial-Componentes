package com.empresa.supportapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.supportapi.model.Cliente;
import com.empresa.supportapi.model.Tecnico;
import com.empresa.supportapi.service.AuthService;
import com.empresa.supportapi.service.TecnicoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
@Tag(
    name = "Autenticación y Registro",
    description = "Controlador para la gestión de inicio de sesión y registro de usuarios (clientes, técnicos y administradores)."
)
public class AuthController {

    private final AuthService authService;
    private final TecnicoService tecnicoService;

    public AuthController(AuthService authService, TecnicoService tecnicoService) {
        this.authService = authService;
        this.tecnicoService = tecnicoService;
    }

    // === Registro público de clientes ===
    @Operation(
        summary = "Registrar cliente",
        description = "Permite registrar un nuevo cliente en el sistema. Este endpoint es público y no requiere autenticación."
    )
    @PostMapping("/register/cliente")
    public ResponseEntity<?> registerCliente(@RequestBody Cliente cliente) {
        try {
            Cliente registrado = authService.register(cliente);
            return ResponseEntity.ok(Map.of(
                "mensaje", "Cliente registrado exitosamente",
                "cliente", registrado
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of(
                "error", e.getMessage()
            ));
        }
    }

    // === Registro de técnicos (solo ADMIN) ===
    @Operation(
        summary = "Registrar técnico",
        description = "Permite registrar un nuevo técnico en el sistema. Solo puede ser ejecutado por un usuario con rol ADMIN."
    )
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/register/tecnico")
    public ResponseEntity<?> registerTecnico(@RequestBody Tecnico tecnico) {
        try {
            Tecnico registrado = tecnicoService.crearTecnico(tecnico);
            return ResponseEntity.ok(Map.of(
                "mensaje", "Técnico registrado exitosamente",
                "tecnico", registrado
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of(
                "error", e.getMessage()
            ));
        }
    }

    // === Login solo para clientes ===
    @Operation(
        summary = "Iniciar sesión (Cliente)",
        description = "Permite que un cliente inicie sesión en el sistema proporcionando su correo y contraseña."
    )
    @PostMapping("/login")
    public ResponseEntity<?> loginCliente(@RequestBody Map<String, String> datos) {
        try {
            String correo = datos.get("correo");
            String password = datos.get("password");
            Cliente cliente = authService.login(correo, password);
            return ResponseEntity.ok(Map.of(
                "mensaje", "Login exitoso",
                "rol", "CLIENTE",
                "usuario", cliente
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(Map.of(
                "error", "Credenciales incorrectas o usuario no encontrado"
            ));
        }
    }

    // === Listar todos los clientes (ADMIN y TECNICO) ===
    @Operation(
        summary = "Listar clientes",
        description = "Devuelve la lista completa de clientes registrados. Solo accesible por ADMIN o TÉCNICO."
    )
    @PreAuthorize("hasAnyRole('ADMIN', 'TECNICO')")
    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getAllClientes() {
        return ResponseEntity.ok(authService.getAllClientes());
    }

    // === Listar todos los técnicos (solo ADMIN) ===
    @Operation(
        summary = "Listar técnicos",
        description = "Devuelve la lista completa de técnicos registrados. Solo accesible por ADMIN."
    )
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/tecnicos")
    public ResponseEntity<List<Tecnico>> getAllTecnicos() {
        return ResponseEntity.ok(tecnicoService.getAllTecnicos());
    }
}
