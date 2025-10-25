package com.empresa.supportapi.Interfaces;

import com.empresa.supportapi.model.Tecnico;

/**
 * Interfaz que define las operaciones permitidas para el rol Técnico.
 * El técnico solo puede consultar y actualizar su propio perfil.
 */
public interface ITecnicoService {

    // Obtener los datos del técnico (su propio perfil)
    Tecnico obtenerPorId(Long id);

    // Actualizar los datos del técnico (su propio perfil)
    Tecnico actualizar(Long id, Tecnico tecnico);
}
