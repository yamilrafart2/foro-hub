# ForoHub - Challenge Backend Alura Latam

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.11-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-00000f?style=for-the-badge&logo=mysql&logoColor=white)

ForoHub es una API REST diseñada para replicar el funcionamiento de un foro de discusión. Es el desafío final del programa de Backend, donde aplicamos conocimientos de persistencia, validaciones y arquitectura limpia.

## 🚀 Estado del Proyecto
Actualmente, el proyecto cuenta con un **CRUD funcional y validado para la entidad de Tópicos**, integrado con una base de datos relacional y controlado mediante migraciones automáticas.

## 📋 Funcionalidades

- **Registro de Tópicos:** Validación de datos obligatorios y lógica para evitar títulos y mensajes duplicados.
- **Listado Paginado:** Consulta de todos los tópicos con soporte para paginación y ordenamiento ascendente por fecha.
- **Detalle Individual:** Endpoint para consultar toda la información de un tópico específico mediante su ID.
- **Actualización:** Edición de título y mensaje con validación de existencia del recurso.
- **Eliminación:** Borrado físico de tópicos de la base de datos con respuesta estándar HTTP 204.

## 🛠️ Tecnologías y Herramientas

- **Lenguaje:** Java 21
- **Framework:** Spring Boot 3.5.11
- **Persistencia:** Spring Data JPA & Hibernate
- **Base de Datos:** MySQL 8.0
- **Migraciones:** Flyway
- **Seguridad:** Spring Security (Configuración base)
- **Documentación/Pruebas:** Insomnia / Postman

## ⚙️ Configuración y Ejecución

### 1. Requisitos previos
- JDK 21 o superior.
- Maven 3.x.
- MySQL 8.0.

### 2. Base de Datos
Crea la base de datos en tu entorno local de MySQL:
```sql
CREATE DATABASE forohub_api;
```

### 3. Variables de Entorno
Configura tu archivo `src/main/resources/application.properties` con tus credenciales locales:
```properties
spring.datasource.url=jdbc:mysql://localhost/forohub_api
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

### 4. Ejecución
Las tablas se crearán automáticamente gracias a **Flyway** al iniciar la aplicación. Puedes ejecutar el proyecto desde tu IDE (IntelliJ) o mediante la terminal:
```shell
mvn spring-boot:run
```

---
Desarrollado por [Yamil Rafart](https://github.com/yamilrafart2) - 2026