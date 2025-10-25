package com.empresa.supportapi.Interfaces;

import java.util.List;

import com.empresa.supportapi.model.Solicitud;

/**
 * Interfaz que define las operaciones principales para la gestión de solicitudes de soporte técnico.
 * Esta interfaz abstrae la lógica de negocio que será implementada por la clase SolicitudService.
 */
public interface ISolicitudService {

    /**
     * Crea y registra una nueva solicitud.
     *
     * @param solicitud objeto Solicitud con los datos a registrar
     * @return la solicitud registrada con ID asignado
     */
    Solicitud save(Solicitud solicitud);

    /**
     * Obtiene todas las solicitudes registradas.
     *
     * @return lista de todas las solicitudes
     */
    List<Solicitud> findAll();

    /**
     * Obtiene las solicitudes de un cliente específico.
     *
     * @param clienteId ID del cliente
     * @return lista de solicitudes del cliente
     */
    List<Solicitud> findByClienteId(Long clienteId);

    /**
     * Actualiza una solicitud existente.
     *
     * @param id ID de la solicitud a actualizar
     * @param solicitud objeto con los nuevos datos
     * @return la solicitud actualizada
     */
    Solicitud update(Long id, Solicitud solicitud);

    /**
     * Elimina una solicitud por su ID.
     *
     * @param id ID de la solicitud a eliminar
     */
    void delete(Long id);

    /**
     * Obtiene una solicitud por su ID.
     *
     * @param id ID de la solicitud
     * @return la solicitud encontrada
     */
    Solicitud findById(Long id);
}
