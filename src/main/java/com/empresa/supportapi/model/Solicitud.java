package com.empresa.supportapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Representa una solicitud de soporte técnico.
 * Aplica principios de POO: encapsulamiento y validación de datos.
 */
@Entity
@Table(name = "solicitudes")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título no puede estar vacío")
    private String titulo;

    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;

    @NotNull(message = "Debe indicar un ID de cliente")
    private Long clienteId;

    @NotNull(message = "Debe indicar un ID de técnico")
    private Long tecnicoId;

    /**
     * Estado actual de la solicitud.
     * Solo puede ser uno de los valores definidos en {@link EstadoSolicitud}.
     */
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Debe especificar un estado de solicitud")
    private EstadoSolicitud estado;

    // =========================
    // Constructores
    // =========================

    /** Constructor vacío requerido por JPA */
    public Solicitud() {}

    /**
     * Constructor completo con todos los atributos.
     *
     * @param id ID de la solicitud
     * @param titulo título de la solicitud
     * @param descripcion descripción de la solicitud
     * @param clienteId ID del cliente que realiza la solicitud
     * @param tecnicoId ID del técnico asignado
     * @param estado estado actual de la solicitud
     */
    public Solicitud(Long id, String titulo, String descripcion, Long clienteId, Long tecnicoId, EstadoSolicitud estado) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.clienteId = clienteId;
        this.tecnicoId = tecnicoId;
        this.estado = estado;
    }

    // =========================
    // Getters y Setters
    // =========================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getTecnicoId() {
        return tecnicoId;
    }

    public void setTecnicoId(Long tecnicoId) {
        this.tecnicoId = tecnicoId;
    }

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitud estado) {
        this.estado = estado;
    }

    // =========================
    // Métodos adicionales (opcional)
    // =========================
    @Override
    public String toString() {
        return "Solicitud{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", clienteId=" + clienteId +
                ", tecnicoId=" + tecnicoId +
                ", estado=" + estado +
                '}';
    }
}
