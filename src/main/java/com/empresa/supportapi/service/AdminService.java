package com.empresa.supportapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.empresa.supportapi.model.Admin;
import com.empresa.supportapi.repository.AdminRepository;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> listarAdmins() {
        return adminRepository.findAll();
    }

    public Optional<Admin> buscarPorId(Long id) {
        return adminRepository.findById(id);
    }

    public Admin registrar(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin actualizar(Long id, Admin adminActualizado) {
        return adminRepository.findById(id).map(admin -> {
            admin.setNombre(adminActualizado.getNombre());
            admin.setCorreo(adminActualizado.getCorreo());
            admin.setPassword(adminActualizado.getPassword());
            return adminRepository.save(admin);
        }).orElse(null);
    }

    public void eliminar(Long id) {
        adminRepository.deleteById(id);
    }
}
