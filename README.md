#Sistema de Gestión de Soporte Técnico


##  Descripción General
**SupportAPI** es una aplicación desarrollada con **Spring Boot** que permite **gestionar solicitudes de soporte técnico** mediante una API REST.  
El sistema permite **registrar, consultar, actualizar y eliminar solicitudes**, aplicando **buenas prácticas de programación orientada a objetos (POO)**, validaciones con anotaciones y una **arquitectura en capas clara y ordenada**.  

El proyecto no usa base de datos; en su lugar, **simula la persistencia de datos en memoria** utilizando estructuras de datos como `List`.

---

## 🎯 Objetivos del Proyecto

- Implementar una API REST funcional en Java con Spring Boot.  
- Aplicar arquitectura en capas (modelo, servicio, controlador).  
- Validar datos con anotaciones de Jakarta Validation.  
- Documentar todos los endpoints mediante Swagger.  
- Realizar pruebas funcionales con Swagger UI y Postman.  
- Simular la persistencia en memoria con colecciones Java.  

---

## 🏗️ Arquitectura del Sistema

El proyecto sigue el patrón **MVC extendido** (Modelo, Servicio, Controlador), garantizando modularidad y fácil mantenimiento.

com.empresa.supportapi
├── model/ → Clases de modelo (Solicitud, EstadoSolicitud)
├── service/ → Lógica de negocio y almacenamiento en memoria
├── controller/ → Endpoints REST
├── repository/ → Estructura para futura integración JPA
└── SupportApiApplication.java → Clase principal de arranque




### 📦 Capas del sistema

- **Model**: Contiene las clases `Solicitud` y `EstadoSolicitud`, representando los datos y su estado.  
- **Service**: Implementa la lógica CRUD sobre una lista en memoria.  
- **Controller**: Expone los endpoints REST y gestiona las peticiones HTTP.  
- **Repository**: Declarado con `JpaRepository`, preparado para integración futura con BD.

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

📍 URL de acceso a Swagger:  
`http://localhost:8080/swagger-ui/index.html`

| Método | Endpoint | Descripción |
|--------|-----------|-------------|
| **GET** | `/api/solicitudes` | Lista todas las solicitudes registradas |
| **GET** | `/api/solicitudes/{id}` | Obtiene una solicitud específica por su ID |
| **POST** | `/api/solicitudes` | Crea una nueva solicitud |
| **PUT** | `/api/solicitudes/{id}` | Actualiza una solicitud existente |
| **DELETE** | `/api/solicitudes/{id}` | Elimina una solicitud por su ID |

---

## 🧩 Ejemplo de Operaciones en Swagger

### 🟢 Crear solicitud (POST)

**Request Body**
```json
{
  "titulo": "Problema con la red",
  "descripcion": "El cliente no puede conectarse al servidor.",
  "clienteId": 101,
  "tecnicoId": 202,
  "estado": "PENDIENTE"
}

// Deberia devolver 

{
  "id": 1,
  "titulo": "Problema con la red",
  "descripcion": "El cliente no puede conectarse al servidor.",
  "clienteId": 101,
  "tecnicoId": 202,
  "estado": "PENDIENTE"
}

