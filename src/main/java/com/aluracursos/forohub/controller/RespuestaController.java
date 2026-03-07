package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.domain.respuesta.DatosDetalleRespuesta;
import com.aluracursos.forohub.domain.respuesta.DatosRegistroRespuesta;
import com.aluracursos.forohub.domain.respuesta.Respuesta;
import com.aluracursos.forohub.domain.respuesta.RespuestaRepository;
import com.aluracursos.forohub.domain.topico.TopicoRepository;
import com.aluracursos.forohub.domain.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroRespuesta datos,
                                    @AuthenticationPrincipal Usuario autor) {

        var topico = topicoRepository.getReferenceById(datos.topicoId());
        var respuesta = new Respuesta(datos, autor, topico);

        respuestaRepository.save(respuesta);

        return ResponseEntity.ok(new DatosDetalleRespuesta(respuesta));
    }

}
