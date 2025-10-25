package com.empresa.supportapi.mapper;

import org.springframework.stereotype.Component;

import com.empresa.supportapi.dto.TecnicoDTO;
import com.empresa.supportapi.model.Tecnico;

@Component
public class TecnicoMapper {

    public TecnicoDTO toDTO(Tecnico tecnico) {
        if (tecnico == null) return null;
        return new TecnicoDTO(tecnico.getId(), tecnico.getNombre(), tecnico.getCorreo(), tecnico.getEspecialidad());
    }

    public Tecnico toEntity(TecnicoDTO tecnicoDTO) {
        if (tecnicoDTO == null) return null;
        Tecnico tecnico = new Tecnico();
        tecnico.setId(tecnicoDTO.getId());
        tecnico.setNombre(tecnicoDTO.getNombre());
        tecnico.setCorreo(tecnicoDTO.getCorreo());
        tecnico.setEspecialidad(tecnicoDTO.getEspecialidad());
        return tecnico;
    }
}
