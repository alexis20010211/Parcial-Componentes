package com.empresa.supportapi.mapper;

import org.springframework.stereotype.Component;

import com.empresa.supportapi.dto.ClienteDTO;
import com.empresa.supportapi.model.Cliente;

/**
 * Mapper para convertir entre Cliente y ClienteDTO.
 * Evita exponer datos sensibles como la contraseña.
 */
@Component
public class ClienteMapper {

    // Convierte entidad → DTO
    public ClienteDTO toDTO(Cliente cliente) {
        if (cliente == null) return null;

        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNombre(cliente.getNombre());
        dto.setCorreo(cliente.getCorreo());
        dto.setTelefono(cliente.getTelefono());
        return dto;
    }

    // Convierte DTO → entidad
    public Cliente toEntity(ClienteDTO dto) {
        if (dto == null) return null;

        Cliente cliente = new Cliente();
        cliente.setId(dto.getId());
        cliente.setNombre(dto.getNombre());
        cliente.setCorreo(dto.getCorreo());
        cliente.setTelefono(dto.getTelefono());

        // 👇 Agregamos un valor por defecto al registrar
        // Esto evita el error "La contraseña no puede estar vacía"
        cliente.setPassword("default123");

        return cliente;
    }
}
