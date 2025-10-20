package com.empresa.supportapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.empresa.supportapi.model.Cliente;

/**
 * Servicio que maneja la lógica de negocio relacionada con los clientes.
 * Simula una base de datos usando una lista en memoria, cumpliendo los
 * requerimientos del proyecto (sin persistencia real).
 */
@Service
public class ClienteService {

    // Simulación de almacenamiento en memoria
    private final List<Cliente> clientes = new ArrayList<>();
    private Long nextId = 1L;

    /**
     * Registra un nuevo cliente en la lista.
     * @param cliente objeto Cliente con datos validados.
     * @return el cliente registrado con ID asignado.
     */
    public Cliente registrar(Cliente cliente) {
        cliente.setId(nextId++);
        clientes.add(cliente);
        return cliente;
    }

    /**
     * Retorna la lista completa de clientes registrados.
     */
    public List<Cliente> listar() {
        return clientes;
    }

    /**
     * Busca un cliente por su ID.
     * @param id identificador del cliente.
     * @return Optional con el cliente encontrado o vacío si no existe.
     */
    public Optional<Cliente> obtenerPorId(Long id) {
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    /**
     * Actualiza los datos de un cliente existente.
     * @param id identificador del cliente a actualizar.
     * @param clienteActualizado datos nuevos del cliente.
     * @return el cliente actualizado.
     */
    public Cliente actualizar(Long id, Cliente clienteActualizado) {
        Optional<Cliente> encontrado = obtenerPorId(id);
        if (encontrado.isPresent()) {
            Cliente existente = encontrado.get();
            existente.setNombre(clienteActualizado.getNombre());
            existente.setCorreo(clienteActualizado.getCorreo());
            existente.setPassword(clienteActualizado.getPassword());
            return existente;
        } else {
            throw new RuntimeException("Cliente no encontrado con ID " + id);
        }
    }

    /**
     * Elimina un cliente de la lista por su ID.
     * @param id identificador del cliente a eliminar.
     */
    public void eliminar(Long id) {
        clientes.removeIf(c -> c.getId().equals(id));
    }
}
