package com.empresa.supportapi.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.empresa.supportapi.model.Solicitud;

/**
 * Repositorio en memoria para manejar las solicitudes de soporte técnico.
 * Cumple con la simulación requerida por la rúbrica del proyecto.
 */
@Repository
public class SolicitudRepository {

    private final Map<Long, Solicitud> solicitudes = new HashMap<>();
    private Long nextId = 1L;

    /** Guarda una nueva solicitud */
    public Solicitud guardar(Solicitud solicitud) {
        solicitud.setId(nextId++);
        solicitudes.put(solicitud.getId(), solicitud);
        return solicitud;
    }

    /** Devuelve todas las solicitudes */
    public List<Solicitud> listar() {
        return new ArrayList<>(solicitudes.values());
    }

    /** Busca una solicitud por su ID */
    public Optional<Solicitud> buscarPorId(Long id) {
        return Optional.ofNullable(solicitudes.get(id));
    }

    /** Actualiza una solicitud existente */
    public Solicitud actualizar(Long id, Solicitud solicitud) {
        if (!solicitudes.containsKey(id)) {
            throw new NoSuchElementException("No existe solicitud con ID " + id);
        }
        solicitud.setId(id);
        solicitudes.put(id, solicitud);
        return solicitud;
    }

    /** Elimina una solicitud por su ID */
    public void eliminar(Long id) {
        solicitudes.remove(id);
    }

    /** Limpia todas las solicitudes (solo para pruebas) */
    public void limpiar() {
        solicitudes.clear();
        nextId = 1L;
    }
}
