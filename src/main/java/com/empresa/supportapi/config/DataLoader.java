package com.empresa.supportapi.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.empresa.supportapi.model.Cliente;
import com.empresa.supportapi.model.EstadoSolicitud;
import com.empresa.supportapi.model.Solicitud;
import com.empresa.supportapi.model.Tecnico;
import com.empresa.supportapi.repository.ClienteRepository;
import com.empresa.supportapi.repository.SolicitudRepository;
import com.empresa.supportapi.repository.TecnicoRepository;

/**
 * Clase de configuración para precargar datos iniciales.
 * Cumple con principios de POO y persistencia simulada en memoria.
 */
@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initData(
            ClienteRepository clienteRepository,
            TecnicoRepository tecnicoRepository,
            SolicitudRepository solicitudRepository) {

        return args -> {
            // Solo cargar si las listas están vacías
            if (clienteRepository.listar().isEmpty() &&
                tecnicoRepository.listar().isEmpty() &&
                solicitudRepository.listar().isEmpty()) {

                // Crear clientes
                Cliente c1 = new Cliente();
                c1.setNombre("Juan Pérez");
                c1.setCorreo("juan.perez@email.com");
                clienteRepository.guardar(c1);

                Cliente c2 = new Cliente();
                c2.setNombre("María Gómez");
                c2.setCorreo("maria.gomez@email.com");
                clienteRepository.guardar(c2);

                // Crear técnicos
                Tecnico t1 = new Tecnico();
                t1.setNombre("Carlos Ruiz");
                t1.setCorreo("carlos.ruiz@empresa.com");
                tecnicoRepository.guardar(t1);

                Tecnico t2 = new Tecnico();
                t2.setNombre("Ana Torres");
                t2.setCorreo("ana.torres@empresa.com");
                tecnicoRepository.guardar(t2);

                // Crear solicitudes de soporte
                Solicitud s1 = new Solicitud();
                s1.setTitulo("Error en inicio de sesión");
                s1.setDescripcion("No puedo acceder con mis credenciales.");
                s1.setClienteId(c1.getId());
                s1.setTecnicoId(t1.getId());
                s1.setEstado(EstadoSolicitud.PENDIENTE);
                solicitudRepository.guardar(s1);

                Solicitud s2 = new Solicitud();
                s2.setTitulo("Falla en impresora");
                s2.setDescripcion("La impresora no responde.");
                s2.setClienteId(c2.getId());
                s2.setTecnicoId(t2.getId());
                s2.setEstado(EstadoSolicitud.EN_PROCESO);
                solicitudRepository.guardar(s2);

                System.out.println("✅ Datos iniciales cargados correctamente en memoria.");
            } else {
                System.out.println("⚠️ Los datos ya existen, no se recargaron.");
            }
        };
    }
}
