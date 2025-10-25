package com.empresa.supportapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.empresa.supportapi.Interfaces.ISolicitudService;
import com.empresa.supportapi.model.Solicitud;

@Service
public class SolicitudService implements ISolicitudService {

    // Lista simulando la base de datos
    private final List<Solicitud> solicitudes = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public Solicitud save(Solicitud solicitud) {
        solicitud.setId(nextId++);
        solicitudes.add(solicitud);
        return solicitud;
    }

    @Override
    public List<Solicitud> findAll() {
        return new ArrayList<>(solicitudes);
    }

    @Override
    public List<Solicitud> findByClienteId(Long clienteId) {
        List<Solicitud> resultado = new ArrayList<>();
        for (Solicitud s : solicitudes) {
            if (s.getClienteId().equals(clienteId)) {
                resultado.add(s);
            }
        }
        return resultado;
    }

    @Override
    public Solicitud findById(Long id) {
        Optional<Solicitud> s = solicitudes.stream()
                                           .filter(sol -> sol.getId().equals(id))
                                           .findFirst();
        return s.orElse(null);
    }

    @Override
    public Solicitud update(Long id, Solicitud solicitud) {
        for (int i = 0; i < solicitudes.size(); i++) {
            if (solicitudes.get(i).getId().equals(id)) {
                solicitud.setId(id); // mantener el ID original
                solicitudes.set(i, solicitud);
                return solicitud;
            }
        }
        return null; // no encontrado
    }

    @Override
    public void delete(Long id) {
        solicitudes.removeIf(sol -> sol.getId().equals(id));
    }
}
