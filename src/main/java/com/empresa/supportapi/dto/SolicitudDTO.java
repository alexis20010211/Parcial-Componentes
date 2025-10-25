package com.empresa.supportapi.dto;

import com.empresa.supportapi.model.EstadoSolicitud;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO de Solicitud de soporte técnico")
public class SolicitudDTO {

    private Long id;
    private String titulo;
    private String descripcion;
    private Long clienteId;
    private Long tecnicoId;
    private EstadoSolicitud estado;

    public SolicitudDTO() {}

    public SolicitudDTO(Long id, String titulo, String descripcion, Long clienteId, Long tecnicoId, EstadoSolicitud estado) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.clienteId = clienteId;
        this.tecnicoId = tecnicoId;
        this.estado = estado;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public Long getTecnicoId() { return tecnicoId; }
    public void setTecnicoId(Long tecnicoId) { this.tecnicoId = tecnicoId; }

    public EstadoSolicitud getEstado() { return estado; }
    public void setEstado(EstadoSolicitud estado) { this.estado = estado; }
}
