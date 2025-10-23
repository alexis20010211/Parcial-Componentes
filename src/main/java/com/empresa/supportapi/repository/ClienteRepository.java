package com.empresa.supportapi.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.empresa.supportapi.model.Cliente;

/**
 * Simula un repositorio de clientes en memoria.
 * Implementa operaciones CRUD básicas usando un HashMap.
 */
@Repository
public class ClienteRepository {

    private final Map<Long, Cliente> clientes = new HashMap<>();
    private Long nextId = 1L;

    /** Guarda un nuevo cliente en memoria */
    public Cliente guardar(Cliente cliente) {
        cliente.setId(nextId++);
        clientes.put(cliente.getId(), cliente);
        return cliente;
    }

    /** Devuelve todos los clientes registrados */
    public List<Cliente> listar() {
        return new ArrayList<>(clientes.values());
    }

    /** Busca un cliente por su ID */
    public Optional<Cliente> buscarPorId(Long id) {
        return Optional.ofNullable(clientes.get(id));
    }

    /** Actualiza un cliente existente */
    public Cliente actualizar(Long id, Cliente cliente) {
        if (!clientes.containsKey(id)) {
            throw new NoSuchElementException("No existe cliente con ID " + id);
        }
        cliente.setId(id);
        clientes.put(id, cliente);
        return cliente;
    }

    /** Elimina un cliente */
    public void eliminar(Long id) {
        clientes.remove(id);
    }

    /** Limpia todos los registros (solo para pruebas) */
    public void limpiar() {
        clientes.clear();
        nextId = 1L;
    }
}
