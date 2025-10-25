package com.empresa.supportapi.mapper;

import org.springframework.stereotype.Component;

import com.empresa.supportapi.dto.AdminDTO;
import com.empresa.supportapi.model.Admin;

@Component
public class AdminMapper {

    public AdminDTO toDTO(Admin admin) {
        if (admin == null) return null;
        return new AdminDTO(admin.getId(), admin.getNombre(), admin.getCorreo());
    }

    public Admin toEntity(AdminDTO adminDTO) {
        if (adminDTO == null) return null;
        Admin admin = new Admin();
        admin.setId(adminDTO.getId());
        admin.setNombre(adminDTO.getNombre());
        admin.setCorreo(adminDTO.getCorreo());
        return admin;
    }
}
