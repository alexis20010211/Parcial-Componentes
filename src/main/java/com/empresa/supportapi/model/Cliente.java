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
 * Clase modelo que representa a un cliente dentro del sistema de soporte.
 * Aplica los principios de POO (encapsulamiento, claridad y validación).
 * Cumple con las buenas prácticas de modelado en una arquitectura en capas.
 */
@Entity
@Table(name = "clientes")
@Schema(description = "Modelo que representa a un cliente del sistema")
//TODO: QUIERO OBTENER LA LISTA DE SOLICITUDES PENDIENTES DE UN CLIENTE
public class Cliente {

    // === Atributos ===
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID del cliente", example = "1")
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres")
    @Schema(description = "Nombre completo del cliente", example = "María Rodríguez")
    private String nombre;

    @NotBlank(message = "El correo no puede estar vacío")
    @Email(message = "El formato del correo electrónico no es válido")
    @Schema(description = "Correo electrónico del cliente", example = "maria@gmail.com")
    private String correo;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 6, max = 100, message = "La contraseña debe tener entre 6 y 100 caracteres")
    @Schema(description = "Contraseña de acceso del cliente", example = "123456")
    private String password;

    @NotBlank(message = "El teléfono no puede estar vacío")
    @Size(min = 6, max = 20, message = "El teléfono debe tener entre 6 y 20 caracteres")
    @Schema(description = "Número de teléfono del cliente", example = "987654321")
    private String telefono;

    // === Constructores ===
    public Cliente() {}

    public Cliente(Long id, String nombre, String correo, String password, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.telefono = telefono;
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

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    // === toString ===
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
