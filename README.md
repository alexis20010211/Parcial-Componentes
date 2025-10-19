# SupportAPI (Avance)

> Este repositorio contiene un avance del backend del proyecto. Todavía está en desarrollo.

## Descripción

Este proyecto tiene como objetivo desarrollar una API RESTful utilizando Java y Spring Boot para gestionar solicitudes de soporte técnico. Actualmente, se han implementado las siguientes características:

- Estructura básica del proyecto con Maven.
- Configuración inicial de Spring Boot.
- Definición de clases modelo para representar las entidades principales.

## Estructura del Proyecto

supportapi/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/
│ │ │ └── empresa/
│ │ │ └── supportapi/
│ │ │ ├── model/
│ │ │ └── SupportapiApplication.java
│ │ └── resources/
│ │ └── application.properties
├── .gitignore
├── .gitattributes
├── mvnw
├── mvnw.cmd
└── pom.xml


## Tecnologías Utilizadas

- Java 17
- Spring Boot
- Maven

## Instalación

1. Clonar el repositorio:

   ```bash
   git clone https://github.com/alexis20010211/Parcial-Componentes.git
   cd Parcial-Componentes/supportapi

Compilar el proyecto:

- mvn clean install

Ejecutar la aplicación:

- mvn spring-boot:run
## Pruebas realizadas

- Se ha configurado **Swagger** para la documentación y prueba de los endpoints de la API.
- Se han realizado pruebas funcionales con **Postman** para verificar:
  - Creación de solicitudes (`POST /solicitudes`)
  - Consulta de solicitudes (`GET /solicitudes`)
  - Actualización de solicitudes (`PUT /solicitudes/{id}`)
  - Eliminación de solicitudes (`DELETE /solicitudes/{id}`)
- Todas las pruebas han sido satisfactorias hasta la fecha, confirmando el correcto funcionamiento de los endpoints implementados.
