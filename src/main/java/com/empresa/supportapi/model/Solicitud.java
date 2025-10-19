package com.empresa.supportapi.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Solicitud {
    private Long id;

    @NotBlank(message = "El título no puede estar vacío")
    private String titulo;

    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;

    @NotNull(message = "Debe indicar un ID de cliente")
    private Long clienteId;

    @NotNull(message = "Debe indicar un ID de técnico")
    private Long tecnicoId;

    // Constructor vacío
    public Solicitud() {}

    // Constructor completo
    public Solicitud(Long id, String titulo, String descripcion, Long clienteId, Long tecnicoId) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.clienteId = clienteId;
        this.tecnicoId = tecnicoId;
    }

    // Getters y setters
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
}
