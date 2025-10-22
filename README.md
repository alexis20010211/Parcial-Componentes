# 🧰 Sistema de Gestión de Soporte Técnico — *SupportAPI*

## 📖 Descripción General

**SupportAPI** es una aplicación desarrollada con **Spring Boot** que permite gestionar solicitudes de soporte técnico mediante una **API RESTful**.  
Su objetivo principal es registrar, consultar, actualizar y eliminar solicitudes de soporte de forma ordenada y centralizada.

Esta versión utiliza **almacenamiento en memoria** (colecciones Java) para simular una base de datos, lo que permite realizar pruebas sin necesidad de configurar un servidor de base de datos real.

---

## ⚙️ Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

- **Java 17 o superior**  
- **Maven 3.9.x o superior**  
- **Git** (opcional, para clonar el repositorio)

---

## 🚀 Instalación y Ejecución


### 🔧 Ejecución paso a paso

1. **Clonar el repositorio**

   ```bash
   git clone https://github.com/alexis20010211/Parcial-Componentes.git


2. Estar dentro de la carpeta del proyecto 


Parcial-Componentes

3. Compilar y ejecutar la aplicación

- mvn spring-boot:run

4. Acceder a Swagger UI para probar la API

Abre en tu navegador:
👉 http://localhost:8080/swagger-ui/index.html




📬 Endpoints Principales

Una vez en ejecución, podrás probar los siguientes endpoints desde Swagger UI o Postman:

Controlador	Endpoint base	Descripción
Solicitudes	/api/solicitudes	CRUD de solicitudes de soporte
Clientes	/api/clientes	CRUD de clientes
Técnicos	/api/tecnicos	CRUD de técnicos
Autenticación	/api/auth	Registro e inicio de sesión de usuarios

🧩 Ejemplo de Petición (POST)

Endpoint:
POST /api/solicitudes

Cuerpo de la solicitud (JSON):

{
  "titulo": "Problema con la red",
  "descripcion": "El cliente no puede conectarse al servidor.",
  "clienteId": 1,
  "tecnicoId": 2,
  "estado": "PENDIENTE"
}
