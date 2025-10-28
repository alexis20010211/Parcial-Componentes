# 🧰 Sistema de Gestión de Soporte Técnico — SupportAPI

## 📖 Descripción General

*SupportAPI* es una aplicación desarrollada con *Spring Boot* que permite gestionar solicitudes de soporte técnico mediante una *API RESTful*.  
Su objetivo principal es registrar, consultar, actualizar y eliminar solicitudes de soporte de forma ordenada y centralizada.

Esta versión utiliza *almacenamiento en memoria* (colecciones Java) para simular una base de datos, lo que permite realizar pruebas sin necesidad de configurar un servidor de base de datos real.

---

## ⚙️ Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

- *Java 17 o superior*  
- *Maven 3.9.x o superior* (opcional, puedes usar el wrapper incluido)  
- *Git* (opcional, para clonar el repositorio)

---


## 🚀 Instalación y Ejecución



### 🚀 Ejecución paso a paso

1. **🛠 Clonar el repositorio:**

```bash
git clone https://github.com/alexis20010211/Parcial-Componentes.git

📂 Entrar a la carpeta del proyecto:

cd Parcial-Componentes


Compilar y ejecutar la aplicación:

mvn spring-boot:run

Acceder a Swagger UI para probar la API:

http://localhost:8080/swagger-ui/index.html



## 👤 Usuarios y Roles para Pruebas (HTTP Basic)

                                      
## 👤 Usuarios y Roles para Pruebas (HTTP Basic)

| Usuario  | Contraseña | Rol       | Acceso Principal en la API |
|----------|------------|-----------|----------------------------------------------------------------------|
| 🛡️ **admin**  | `admin123` | **ADMIN**   | ✅ Acceso completo a **todos los endpoints**|
| 🛠️ **tecnico**| `tec123`   | **TECNICO** | ⚡ Gestionar **clientes**, **solicitudes** y **estados de solicitudes** |
| 👤 **cliente**| `cli123`   | **CLIENTE** | 📄 Gestionar únicamente **sus solicitudes**|
