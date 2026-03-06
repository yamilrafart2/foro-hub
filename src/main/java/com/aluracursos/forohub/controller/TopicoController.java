package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.domain.curso.Curso;
import com.aluracursos.forohub.domain.curso.CursoRepository;
import com.aluracursos.forohub.domain.topico.DatosDetalleTopico;
import com.aluracursos.forohub.domain.topico.DatosRegistroTopico;
import com.aluracursos.forohub.domain.topico.Topico;
import com.aluracursos.forohub.domain.topico.TopicoRepository;
import com.aluracursos.forohub.domain.usuario.Usuario;
import com.aluracursos.forohub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    @PostMapping
    public ResponseEntity registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriBuilder) {

        // Validación de Regla de Negocio: No permitir duplicados (Título + Mensaje)
        if (topicoRepository.existsByTituloAndMensaje(datosRegistroTopico.titulo(), datosRegistroTopico.mensaje())) {
            return ResponseEntity.badRequest().body("Ya existe un tópico con el mismo título y mensaje.");
        }

        // Obtener las referencias del usuario y el curso desde la base de datos
        Usuario autor = usuarioRepository.getReferenceById(datosRegistroTopico.autorId());
        Curso curso = cursoRepository.getReferenceById(datosRegistroTopico.cursoId());

        // Crear y guardar el nuevo tópico
        Topico topico = new Topico(datosRegistroTopico, autor, curso);
        topicoRepository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));

    }

}
