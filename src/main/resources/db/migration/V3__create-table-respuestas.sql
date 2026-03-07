CREATE TABLE respuestas (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            mensaje TEXT NOT NULL,
                            fecha_creacion DATETIME NOT NULL,
                            solucion TINYINT NOT NULL DEFAULT 0,
                            autor_id BIGINT NOT NULL,
                            topico_id BIGINT NOT NULL,
                            CONSTRAINT fk_respuestas_autor_id FOREIGN KEY (autor_id) REFERENCES usuarios(id),
                            CONSTRAINT fk_respuestas_topico_id FOREIGN KEY (topico_id) REFERENCES topicos(id)
);