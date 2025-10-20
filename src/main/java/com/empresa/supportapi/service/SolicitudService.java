package com.empresa.supportapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.empresa.supportapi.Interfaces.ISolicitudService;
import com.empresa.supportapi.model.EstadoSolicitud;
import com.empresa.supportapi.model.Solicitud;

/**
 * Implementación en memoria del servicio de gestión de solicitudes de soporte técnico.
 * 
 * Esta clase simula la persistencia de datos utilizando una lista en memoria,
 * cumpliendo con la arquitectura de capas del proyecto (modelo → servicio → controlador).
 */
@Service
public class SolicitudService implements ISolicitudService {

    // Simulación de base de datos en memoria
    private final List<Solicitud> solicitudes = new ArrayList<>();
    private Long nextId = 1L;

    /**
     * Retorna todas las solicitudes registradas.
     */
    @Override
    public List<Solicitud> listar() {
        return solicitudes;
    }

    /**
     * Registra una nueva solicitud en memoria.
     */
    @Override
    public Solicitud registrar(Solicitud solicitud) {
        solicitud.setId(nextId++);

        // Si no se envía estado, se asigna por defecto "PENDIENTE"
        if (solicitud.getEstado() == null) {
            solicitud.setEstado(EstadoSolicitud.PENDIENTE);
        }

        solicitudes.add(solicitud);
        return solicitud;
    }

    /**
     * Busca una solicitud por su ID.
     */
    @Override
    public Optional<Solicitud> obtenerPorId(Long id) {
        return solicitudes.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
    }

    /**
     * Actualiza los datos de una solicitud existente.
     */
    @Override
    public Optional<Solicitud> actualizar(Long id, Solicitud solicitudActualizada) {
        for (int i = 0; i < solicitudes.size(); i++) {
            if (solicitudes.get(i).getId().equals(id)) {
                // Mantener el mismo ID
                solicitudActualizada.setId(id);

                // Si no se envía un estado nuevo, conservar el anterior
                if (solicitudActualizada.getEstado() == null) {
                    solicitudActualizada.setEstado(solicitudes.get(i).getEstado());
                }

                solicitudes.set(i, solicitudActualizada);
                return Optional.of(solicitudActualizada);
            }
        }
        return Optional.empty();
    }

    /**
     * Elimina una solicitud por su ID.
     */
    @Override
    public boolean eliminar(Long id) {
        return solicitudes.removeIf(s -> s.getId().equals(id));
    }
}
