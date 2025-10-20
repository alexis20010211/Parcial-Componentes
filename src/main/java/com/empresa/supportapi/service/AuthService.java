package com.empresa.supportapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.empresa.supportapi.model.Cliente;

@Service
public class AuthService {

    // Lista en memoria simulando la base de datos
    private final List<Cliente> clientes = new ArrayList<>();

    // Registrar un nuevo cliente
    public Cliente register(Cliente nuevoCliente) {
        // Verificar si el correo ya existe
        Optional<Cliente> existente = clientes.stream()
                .filter(c -> c.getCorreo().equalsIgnoreCase(nuevoCliente.getCorreo()))
                .findFirst();

        if (existente.isPresent()) {
            throw new RuntimeException("El correo ya está registrado");
        }

        clientes.add(nuevoCliente);
        return nuevoCliente;
    }

    // Iniciar sesión
    public Cliente login(String correo, String password) {
        return clientes.stream()
                .filter(c -> c.getCorreo().equalsIgnoreCase(correo) && c.getPassword().equals(password))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Credenciales incorrectas"));
    }

    // Obtener todos los clientes (solo para pruebas)
    public List<Cliente> getAllClientes() {
        return clientes;
    }
}
