package com.empresa.supportapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.empresa.supportapi.model.Tecnico;

@Service
public class TecnicoService {

    private final List<Tecnico> tecnicos = new ArrayList<>();
    private Long siguienteId = 1L;

    public Tecnico crearTecnico(Tecnico tecnico) {
        tecnico.setId(siguienteId++);
        tecnicos.add(tecnico);
        return tecnico;
    }

    public List<Tecnico> obtenerTodos() {
        return tecnicos;
    }

    public Tecnico obtenerPorId(Long id) {
        return tecnicos.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Técnico no encontrado con ID: " + id));
    }

    public Tecnico actualizar(Long id, Tecnico tecnico) {
        Tecnico existente = obtenerPorId(id);
        existente.setNombre(tecnico.getNombre());
        existente.setEspecialidad(tecnico.getEspecialidad());
        return existente;
    }

    public void eliminar(Long id) {
        Tecnico tecnico = obtenerPorId(id);
        tecnicos.remove(tecnico);
    }
}
