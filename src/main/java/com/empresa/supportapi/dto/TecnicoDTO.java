package com.empresa.supportapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO de Técnico (perfil simplificado)")
public class TecnicoDTO {

    private Long id;
    private String nombre;
    private String correo;
    private String especialidad;

    public TecnicoDTO() {}

    public TecnicoDTO(Long id, String nombre, String correo, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.especialidad = especialidad;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
}
