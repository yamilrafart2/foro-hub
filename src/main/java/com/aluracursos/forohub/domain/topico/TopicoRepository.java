package com.aluracursos.forohub.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    // Método para verificar duplicados por título y mensaje
    boolean existsByTituloAndMensaje(String titulo, String mensaje);

}
