package com.aluracursos.forohub.domain.respuesta;

import java.time.LocalDateTime;

public record DatosDetalleRespuesta(
        Long id,
        String mensaje,
        String autor,
        Long topicoId,
        LocalDateTime fecha
) {

    public DatosDetalleRespuesta(Respuesta respuesta) {
        this(
                respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getAutor().getNombre(),
                respuesta.getTopico().getId(),
                respuesta.getFechaCreacion()
        );
    }

}
