package com.empresa.supportapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Modelo de técnico")
public class Tecnico {

    @Schema(description = "ID del técnico", example = "1")
    private Long id;

    @Schema(description = "Nombre completo del técnico", example = "Juan Pérez")
    @NotBlank(message = "El nombre del técnico es obligatorio")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;

    @Schema(description = "Especialidad del técnico", example = "Soporte técnico")
    @NotBlank(message = "La especialidad es obligatoria")
    private String especialidad;

    // Constructor vacío
    public Tecnico() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
}
