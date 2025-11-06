🖥️ Sistema de Gestión de Soporte Técnico — SupportAPI
📖 Descripción General

SupportAPI es una aplicación desarrollada con Spring Boot que permite gestionar solicitudes de soporte técnico mediante una API RESTful.
Su objetivo principal es registrar, consultar, actualizar y eliminar solicitudes de soporte de forma ordenada y centralizada.

Esta versión utiliza almacenamiento en memoria (colecciones Java) para simular una base de datos, lo que permite realizar pruebas sin necesidad de configurar un servidor de base de datos real.

⚙️ Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalado:

☕ Java 17 o superior

🧱 Maven 3.9.x o superior (opcional, puedes usar el wrapper incluido)

🧰 Git (opcional, para clonar el repositorio)

🚀 Instalación y Ejecución
🛠 Clonar el repositorio:
git clone https://github.com/alexis20010211/Parcial-Componentes.git

📂 Entrar a la carpeta del proyecto:
cd Parcial-Componentes

⚙️ Verificar estructura de carpetas

Asegúrate de tener la siguiente estructura:

src/
 └── main/
      ├── java/
      │    └── com/empresa/supportapi/
      │         └── SupportapiApplication.java
      └── resources/
           └── application.properties


Y que el archivo principal SupportapiApplication.java tenga el siguiente contenido:

package com.empresa.supportapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SupportapiApplication {
    public static void main(String[] args) {
        SpringApplication.run(SupportapiApplication.class, args);
    }
}

⚠️ Configuración importante

Si no usas una base de datos real, asegúrate de que el archivo application.properties no contenga configuración MySQL activa.
Comenta o elimina líneas como estas:

# spring.datasource.url=jdbc:mysql://localhost:3306/soporte
# spring.datasource.username=root
# spring.datasource.password=1234

🚀 Compilar y ejecutar la aplicación

1️⃣ Compilar sin ejecutar pruebas automáticas (para evitar errores de test):

mvn clean package -DskipTests


2️⃣ Ejecutar la aplicación con Maven:

mvn spring-boot:run


3️⃣ O bien, ejecutar directamente el archivo .jar generado:

java -jar target/supportapi-0.0.1-SNAPSHOT.jar


Cuando veas en la consola:

Tomcat started on port(s): 8080 (http)
Started SupportapiApplication in X.XXX seconds


<<<<<<< HEAD
significa que el servidor se inició correctamente 🎉

🌐 Acceso a la API

Una vez iniciada la aplicación, abre tu navegador y visita:

Swagger UI:
👉 http://localhost:8080/swagger-ui/index.html

👤 Usuarios y Roles para Pruebas (HTTP Basic)
Usuario	Contraseña	Rol	Acceso Principal en la API
🛡️ admin	admin123	ADMIN	✅ Acceso completo a todos los endpoints
🛠️ tecnico	tec123	TECNICO	⚡ Gestiona clientes, solicitudes y estados de solicitudes
👤 cliente	cli123	CLIENTE	📄 Gestiona únicamente sus solicitudes
🔑 Ejemplo de autenticación en Postman

Usa el método Basic Auth

Ingresa:

Username: admin

Password: admin123

Luego prueba la siguiente URL:

http://localhost:8080/api/admi

🧩 Tecnologías utilizadas

Spring Boot 3.3.4

Spring Web

Spring Data JPA

Spring Security

Validation (Jakarta)

Swagger / OpenAPI 2.6.0

DevTools

Java 17

📄 Licencia

Proyecto académico — Desarrollado para fines educativos por el equipo IDAT.
=======
| Usuario  | Contraseña | Rol       | Acceso Principal en la API |
|----------|------------|-----------|----------------------------------------------------------------------|
| 🛡️ **admin**  | `admin123` | **ADMIN**   | ✅ Acceso completo a **todos los endpoints**|
| 🛠️ **tecnico**| `tec123`   | **TECNICO** | ⚡ Gestionar **clientes**, **solicitudes** y **estados de solicitudes** |
| 👤 **cliente**| `cli123`   | **CLIENTE** | 📄 Gestionar únicamente **sus solicitudes**|


// para entrar al Postman como administrador la url es 
// anteriormente no entraba porque el nombre era admins

http://localhost:8080/api/admi


entrar a basic auth  y poner las contraseñas 
user name : admin
password: admin123
>>>>>>> 511d1bf (se levanto las observaciones)
