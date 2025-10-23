package com.empresa.supportapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Clase modelo que representa a un técnico del sistema de soporte.
 * Aplica principios de POO, validación y claridad de código.
 */
@Entity
@Table(name = "tecnicos")
@Schema(description = "Modelo de técnico")
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID del técnico", example = "1")
    private Long id;

    @Schema(description = "Nombre completo del técnico", example = "Juan Pérez")
    @NotBlank(message = "El nombre del técnico es obligatorio")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    private String nombre;

    @Schema(description = "Correo electrónico del técnico", example = "juan.perez@mail.com")
    @NotBlank(message = "El correo no puede estar vacío")
    @Email(message = "El formato del correo electrónico no es válido")
    private String correo;

    @Schema(description = "Contraseña del técnico", example = "123456")
    @NotBlank(message = "La contraseña no puede estar vacía")
    private String password;

    @Schema(description = "Especialidad del técnico", example = "Soporte técnico")
    @NotBlank(message = "La especialidad es obligatoria")
    private String especialidad;

    // === Constructores ===
    public Tecnico() {}

    public Tecnico(Long id, String nombre, String correo, String password, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.especialidad = especialidad;
    }

    // === Getters y Setters ===
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    // === Método toString (útil para depuración) ===
    @Override
    public String toString() {
        return "Tecnico{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}
