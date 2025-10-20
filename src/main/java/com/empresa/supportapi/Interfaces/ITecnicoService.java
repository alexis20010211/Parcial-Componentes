package com.empresa.supportapi.Interfaces;

import java.util.List;

import com.empresa.supportapi.model.Tecnico;

/**
 * Interfaz que define las operaciones del servicio Técnico.
 * Establece los métodos CRUD básicos.
 */
public interface ITecnicoService {

    List<Tecnico> listar();                  // Obtener todos los técnicos
    Tecnico obtenerPorId(Long id);           // Buscar técnico por ID
    Tecnico registrar(Tecnico tecnico);      // Crear nuevo técnico
    Tecnico actualizar(Long id, Tecnico tecnico);  // Actualizar técnico existente
    void eliminar(Long id);                  // Eliminar técnico por ID
}
