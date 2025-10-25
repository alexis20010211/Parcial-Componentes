package com.empresa.supportapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.supportapi.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByCorreo(String correo);
}
