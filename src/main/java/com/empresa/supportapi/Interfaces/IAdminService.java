package com.empresa.supportapi.Interfaces;

import java.util.List;
import java.util.Optional;

import com.empresa.supportapi.model.Admin;

/**
 * Interfaz que define las operaciones disponibles para la gestión de administradores.
 * Permite mantener una arquitectura limpia y desacoplada.
 */
public interface IAdminService {

    /**
     * Lista todos los administradores registrados.
     * @return lista de admins
     */
    List<Admin> listarAdmins();

    /**
     * Busca un administrador por su ID.
     * @param id identificador del admin
     * @return Optional con el admin encontrado o vacío si no existe
     */
    Optional<Admin> buscarPorId(Long id);

    /**
     * Registra un nuevo administrador.
     * @param admin objeto Admin
     * @return admin registrado
     */
    Admin registrar(Admin admin);

    /**
     * Actualiza un administrador existente.
     * @param id ID del admin a actualizar
     * @param adminAdmin actualizado
     * @return admin actualizado o null si no existe
     */
    Admin actualizar(Long id, Admin admin);

    /**
     * Elimina un administrador por su ID.
     * @param id ID del admin a eliminar
     */
    void eliminar(Long id);
}
