package com.empresa.supportapi.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.empresa.supportapi.model.Tecnico;

/**
 * Simula un repositorio de técnicos en memoria.
 * Permite realizar operaciones CRUD sin base de datos.
 */
@Repository
public class TecnicoRepository {

    private final Map<Long, Tecnico> tecnicos = new HashMap<>();
    private Long nextId = 1L;

    /** Guarda un nuevo técnico */
    public Tecnico guardar(Tecnico tecnico) {
        tecnico.setId(nextId++);
        tecnicos.put(tecnico.getId(), tecnico);
        return tecnico;
    }

    /** Lista todos los técnicos registrados */
    public List<Tecnico> listar() {
        return new ArrayList<>(tecnicos.values());
    }

    /** Busca un técnico por su ID */
    public Optional<Tecnico> buscarPorId(Long id) {
        return Optional.ofNullable(tecnicos.get(id));
    }

    /** Actualiza un técnico existente */
    public Tecnico actualizar(Long id, Tecnico tecnico) {
        if (!tecnicos.containsKey(id)) {
            throw new NoSuchElementException("No existe técnico con ID " + id);
        }
        tecnico.setId(id);
        tecnicos.put(id, tecnico);
        return tecnico;
    }

    /** Elimina un técnico */
    public void eliminar(Long id) {
        tecnicos.remove(id);
    }

    /** Limpia todos los técnicos (solo pruebas) */
    public void limpiar() {
        tecnicos.clear();
        nextId = 1L;
    }
}
