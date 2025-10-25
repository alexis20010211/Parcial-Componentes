package com.empresa.supportapi.mapper;

import org.springframework.stereotype.Component;

import com.empresa.supportapi.dto.SolicitudDTO;
import com.empresa.supportapi.model.Solicitud;

@Component
public class SolicitudMapper {

    public SolicitudDTO toDTO(Solicitud solicitud) {
        if (solicitud == null) return null;
        return new SolicitudDTO(
                solicitud.getId(),
                solicitud.getTitulo(),
                solicitud.getDescripcion(),
                solicitud.getClienteId(),
                solicitud.getTecnicoId(),
                solicitud.getEstado()
        );
    }

    public Solicitud toEntity(SolicitudDTO solicitudDTO) {
        if (solicitudDTO == null) return null;
        Solicitud solicitud = new Solicitud();
        solicitud.setId(solicitudDTO.getId());
        solicitud.setTitulo(solicitudDTO.getTitulo());
        solicitud.setDescripcion(solicitudDTO.getDescripcion());
        solicitud.setClienteId(solicitudDTO.getClienteId());
        solicitud.setTecnicoId(solicitudDTO.getTecnicoId());
        solicitud.setEstado(solicitudDTO.getEstado());
        return solicitud;
    }
}
