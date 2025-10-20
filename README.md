#Sistema de Gestión de Soporte Técnico


##  Descripción General
SupportAPI es una aplicación desarrollada con Spring Boot que permite gestionar solicitudes de soporte técnico mediante una API REST.
La idea principal es poder registrar, consultar, actualizar y eliminar solicitudes de forma ordenada, evitando que se pierda información como sucede cuando todo se anota en papel o correos desordenados.
El proyecto no usa base de datos real; en su lugar, simula el almacenamiento en memoria usando estructuras como List para manejar la información temporalmente.
Esto  para probar lógica de negocio sin necesidad de montar un servidor de base de datos.

---

## 🎯 Objetivos del Proyecto

- Crear una API REST funcional con Java + Spring Boot.  
-Aplicar una arquitectura en capas clara (modelo, servicio, controlador). 
- Validar datos con anotaciones de Jakarta Validation.  
- Documentar todos los endpoints mediante Swagger.  
- Realizar pruebas funcionales con Swagger UI y Postman.  
- Simular la persistencia en memoria con colecciones Java.  

---

## 🏗️ Arquitectura del Sistema

El proyecto sigue el patrón **MVC extendido** (Modelo, Servicio, Controlador), garantizando modularidad y fácil mantenimiento.

src
└── main
    └── java
        └── com.empresa.supportapi
            ├── config
            │   └── SwaggerConfig.java
            ├── controller
            │   ├── AuthController.java
            │   ├── ClienteController.java
            │   ├── SolicitudController.java
            │   └── TecnicoController.java
            ├── exception
            │   └── GlobalExceptionHandler.java
            ├── Interfaces
            │   ├── IClienteService.java
            │   ├── ISolicitudService.java
            │   └── ITecnicoService.java
            ├── model
            │   ├── Cliente.java
            │   ├── EstadoSolicitud.java
            │   ├── Solicitud.java
            │   └── Tecnico.java
            └── service
                ├── AuthService.java
                ├── ClienteService.java
                ├── SolicitudService.java
                ├── TecnicoService.java
                └── SupportapiApplication.java

### 📦 Capas del sistema

-   Model → Clases Solicitud, EstadoSolicitud, Cliente y Tecnico.
- **Service**: Implementa la lógica CRUD sobre una lista en memoria.  
- **Controller**: Expone los endpoints REST y gestiona las peticiones HTTP.  
- **Exception** → Manejo de errores centralizado para respuestas limpias y claras.
-**SwaggerConfig** → Configuración de la documentación automática.

---

## ⚙️ Tecnologías Utilizadas

- **Java 17**  
- **Spring Boot 3.3.x**  
- **Spring Web**  
- **Spring Validation (Jakarta)**  
- **Swagger / Springdoc OpenAPI**  
- **Maven**

---


## 🧱 Endpoints Documentados en Swagger

📍 **URL de acceso a Swagger:**  
http://localhost:8080/swagger-ui/index.html

---

### 📨 **Solicitudes-Controller**

| Método      | Endpoint                      | Descripción                                      |
|-------------|-------------------------------|--------------------------------------------------|
| **GET**     | `/api/solicitudes`            | Lista todas las solicitudes registradas          |
| **GET**     | `/api/solicitudes/{id}`       | Obtiene una solicitud específica por su ID       |
| **POST**    | `/api/solicitudes`            | Crea una nueva solicitud                         |
| **PUT**     | `/api/solicitudes/{id}`       | Actualiza una solicitud existente                |
| **DELETE**  | `/api/solicitudes/{id}`       | Elimina una solicitud por su ID                  |

---

### 👤 **Clientes-Controller**

| Método      | Endpoint                  | Descripción                                |
|-------------|---------------------------|--------------------------------------------|
| **GET**     | `/api/clientes`           | Lista todos los clientes                   |
| **GET**     | `/api/clientes/{id}`      | Obtiene un cliente por su ID              |
| **POST**    | `/api/clientes`           | Crea un nuevo cliente                      |
| **PUT**     | `/api/clientes/{id}`      | Actualiza un cliente existente             |
| **DELETE**  | `/api/clientes/{id}`      | Elimina un cliente por su ID               |

---

### 🧑 **Técnicos-Controller**

| Método      | Endpoint                  | Descripción                                |
|-------------|---------------------------|--------------------------------------------|
| **GET**     | `/api/tecnicos`           | Lista todos los técnicos                   |
| **GET**     | `/api/tecnicos/{id}`      | Obtiene un técnico por su ID              |
| **POST**    | `/api/tecnicos`           | Crea un nuevo técnico                      |
| **PUT**     | `/api/tecnicos/{id}`      | Actualiza un técnico existente             |
| **DELETE**  | `/api/tecnicos/{id}`      | Elimina un técnico por su ID               |

---

### 🔐 **Auth-Controller**

| Método      | Endpoint                   | Descripción                                 |
|-------------|----------------------------|---------------------------------------------|
| **POST**    | `/api/auth/register`       | Registra un nuevo usuario                   |
| **POST**    | `/api/auth/login`          | Inicia sesión y devuelve el token JWT       |
| **GET**     | `/api/auth/clientes`       | Obtiene la lista de clientes autenticados   |


---

## 🧩 Ejemplo de Operaciones en Swagger

### 🟢 Crear solicitud (POST)

**Request Body**
```json
{
  "titulo": "Problema con la red",
  "descripcion": "El cliente no puede conectarse al servidor.",
  "clienteId": 01,
  "tecnicoId": 02,
  "estado": "PENDIENTE"
}

// Deberia devolver 

{
  "id": 1,
  "titulo": "Problema con la red",
  "descripcion": "El cliente no puede conectarse al servidor.",
  "clienteId": 01,
  "tecnicoId": 02,
  "estado": "PENDIENTE"
}

