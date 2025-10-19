package com.empresa.supportapi.service;

import java.util.List;
import java.util.Optional;

import com.empresa.supportapi.model.Solicitud;

/**
 * Interfaz que define las operaciones principales para la gestión de solicitudes de soporte técnico.
 * 
 * Esta interfaz abstrae la lógica de negocio que será implementada por la clase
 * {@link com.empresa.supportapi.service.SolicitudService}.
 */
public interface ISolicitudService {

    /**
     * Retorna la lista completa de solicitudes registradas.
     *
     * @return lista de objetos {@link Solicitud}
     */
    List<Solicitud> listar();

    /**
     * Registra una nueva solicitud en la lista en memoria.
     *
     * @param solicitud objeto con los datos a registrar
     * @return la solicitud registrada con su ID asignado
     */
    Solicitud registrar(Solicitud solicitud);

    /**
     * Busca una solicitud por su identificador único.
     *
     * @param id identificador de la solicitud
     * @return un {@link Optional} que puede contener la solicitud encontrada
     */
    Optional<Solicitud> obtenerPorId(Long id);

    /**
     * Actualiza los datos de una solicitud existente.
     *
     * @param id identificador de la solicitud a actualizar
     * @param solicitudActualizada objeto con los nuevos datos
     * @return un {@link Optional} con la solicitud actualizada, si existe
     */
    Optional<Solicitud> actualizar(Long id, Solicitud solicitudActualizada);

    /**
     * Elimina una solicitud del registro.
     *
     * @param id identificador de la solicitud a eliminar
     * @return true si la solicitud fue eliminada correctamente, false si no existe
     */
    boolean eliminar(Long id);
}
