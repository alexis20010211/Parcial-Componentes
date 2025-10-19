package com.empresa.supportapi.model;

import jakarta.validation.constraints.NotBlank;

public class Tecnico {
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "La especialidad no puede estar vacía")
    private String especialidad;

    // Constructor vacío
    public Tecnico() {}

    // Constructor completo
    public Tecnico(Long id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
}
