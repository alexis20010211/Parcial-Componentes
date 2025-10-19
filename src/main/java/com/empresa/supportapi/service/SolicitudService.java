package com.empresa.supportapi.service;

import com.empresa.supportapi.model.Solicitud;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitudService {

    // Lista en memoria tipada correctamente
    private final List<Solicitud> solicitudes = new ArrayList<>();
    private Long nextId = 1L;

    // Listar todas las solicitudes
    public List<Solicitud> listar() {
        return solicitudes; // List<Solicitud>, coincidiendo con el controlador
    }

    // Registrar nueva solicitud
    public Solicitud registrar(Solicitud solicitud) {
        solicitud.setId(nextId++);
        solicitudes.add(solicitud);
        return solicitud;
    }

    // Obtener solicitud por ID
    public Optional<Solicitud> obtenerPorId(Long id) {
        return solicitudes.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
    }

    // Actualizar solicitud existente
    public Optional<Solicitud> actualizar(Long id, Solicitud solicitudActualizada) {
        for (int i = 0; i < solicitudes.size(); i++) {
            if (solicitudes.get(i).getId().equals(id)) {
                solicitudActualizada.setId(id);
                solicitudes.set(i, solicitudActualizada);
                return Optional.of(solicitudActualizada);
            }
        }
        return Optional.empty();
    }

    // Eliminar solicitud
    public boolean eliminar(Long id) {
        return solicitudes.removeIf(s -> s.getId().equals(id));
    }
}
