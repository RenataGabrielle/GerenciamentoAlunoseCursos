package com.exemplo.universidade.controller;

import com.exemplo.universidade.dto.CursoDTO;
import com.exemplo.universidade.entity.Curso;
import com.exemplo.universidade.service.CursoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public Curso criar(@RequestBody CursoDTO dto) {
        Curso curso = Curso.builder()
                .nome(dto.getNome())
                .cargaHoraria(dto.getCargaHoraria())
                .build();
        return cursoService.salvar(curso);
    }

    @GetMapping
    public List<Curso> listarTodos() {
        return cursoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Curso buscarPorId(@PathVariable Long id) {
        return cursoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Curso atualizar(@PathVariable Long id, @RequestBody CursoDTO dto) {
        Curso curso = Curso.builder()
                .nome(dto.getNome())
                .cargaHoraria(dto.getCargaHoraria())
                .build();
        return cursoService.atualizar(id, curso);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        cursoService.deletar(id);
    }
}
