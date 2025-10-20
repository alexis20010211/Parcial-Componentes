package com.empresa.supportapi.Interfaces;

import java.util.List;

import com.empresa.supportapi.model.Cliente;

/**
 * Interfaz que define las operaciones del servicio Cliente.
 * Permite mantener una arquitectura limpia y desacoplada.
 */
public interface IClienteService {

    List<Cliente> listar();                 // Obtener todos los clientes
    Cliente obtenerPorId(Long id);          // Buscar cliente por ID
    Cliente registrar(Cliente cliente);     // Crear nuevo cliente
    Cliente actualizar(Long id, Cliente cliente);  // Actualizar cliente existente
    void eliminar(Long id);                 // Eliminar cliente por ID
}
