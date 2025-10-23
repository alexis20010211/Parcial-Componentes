// Manejar respuestas HTTP (ResponseEntity)
// Anotar controladores y endpoints (@RestController, @GetMapping, @PostMapping, etc.)
// Permitir llamadas desde el frontend (CORS con @CrossOrigin)
// Usar tu modelo (Cliente)
// Llamar al servicio de autenticación (AuthService)

package com.empresa.supportapi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.supportapi.model.Cliente;
import com.empresa.supportapi.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    // === Constructor ===
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // === 1️⃣ Registro ===
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Cliente cliente) {
        try {
            Cliente registrado = authService.register(cliente);
            return ResponseEntity.ok(Map.of(
                "mensaje", "Registro exitoso",
                "cliente", registrado
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of(
                "error", e.getMessage()
            ));
        }
    }

    // === 2️⃣ Login ===
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> datos) {
        try {
            String correo = datos.get("correo");
            String password = datos.get("password");
            Cliente cliente = authService.login(correo, password);

            return ResponseEntity.ok(Map.of(
                "mensaje", "Login exitoso",
                "cliente", cliente
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(Map.of(
                "error", e.getMessage()
            ));
        }
    }

    // === 3️⃣ Obtener todos los clientes (solo para pruebas) ===
    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getAll() {
        return ResponseEntity.ok(authService.getAllClientes());
    }
}
