package com.empresa.supportapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO para transferir datos de Cliente sin exponer la contraseña.
 */
@Schema(description = "Datos públicos del cliente (sin contraseña)")
public class ClienteDTO {

    private Long id;
    private String nombre;
    private String correo;
    private String telefono;

    public ClienteDTO() {}

    public ClienteDTO(Long id, String nombre, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
