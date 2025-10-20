package com.empresa.supportapi.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * Clase modelo que representa a un cliente dentro del sistema de soporte.
 * Cumple con los principios de encapsulamiento, validación y claridad de código.
 */
public class Cliente {

    // === Atributos ===
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El correo no puede estar vacío")
    @Email(message = "El formato del correo electrónico no es válido")
    private String correo;

    @NotBlank(message = "La contraseña no puede estar vacía")
    private String password;

    // === Constructores ===

    /** Constructor vacío requerido por Spring */
    public Cliente() {
    }

    /** Constructor completo */
    public Cliente(Long id, String nombre, String correo, String password) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

    // === Getters y Setters ===

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // === Método toString ===
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
