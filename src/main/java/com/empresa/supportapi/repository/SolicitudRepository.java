package com.empresa.supportapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresa.supportapi.model.Solicitud;

@Repository
public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    // Aquí puedes definir métodos personalizados si los necesitas más adelante.
}
