CREATE TABLE usuarios (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nombre VARCHAR(255) NOT NULL,
                          correo_electronico VARCHAR(255) NOT NULL UNIQUE,
                          contrasena VARCHAR(255) NOT NULL
);

CREATE TABLE cursos (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        nombre VARCHAR(255) NOT NULL,
                        categoria VARCHAR(255) NOT NULL
);

CREATE TABLE topicos (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         titulo VARCHAR(255) NOT NULL UNIQUE,
                         mensaje TEXT NOT NULL,
                         fecha_creacion DATETIME NOT NULL,
                         status VARCHAR(50) NOT NULL,
                         autor_id BIGINT NOT NULL,
                         curso_id BIGINT NOT NULL,
                         CONSTRAINT fk_topicos_autor_id FOREIGN KEY (autor_id) REFERENCES usuarios(id),
                         CONSTRAINT fk_topicos_curso_id FOREIGN KEY (curso_id) REFERENCES cursos(id)
);