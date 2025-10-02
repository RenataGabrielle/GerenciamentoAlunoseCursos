package com.exemplo.universidade.controller;

import com.exemplo.universidade.dto.AlunoDTO;
import com.exemplo.universidade.entity.Aluno;
import com.exemplo.universidade.service.AlunoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public Aluno criar(@RequestBody AlunoDTO dto) {
        Aluno aluno = Aluno.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .dataNascimento(dto.getDataNascimento())
                .build();
        return alunoService.salvar(aluno, dto.getCursoId());
    }

    @GetMapping
    public List<Aluno> listarTodos() {
        return alunoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Aluno buscarPorId(@PathVariable Long id) {
        return alunoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Aluno atualizar(@PathVariable Long id, @RequestBody AlunoDTO dto) {
        Aluno aluno = Aluno.builder()
                .nome(dto.getNome())
                .email(dto.getEmail())
                .dataNascimento(dto.getDataNascimento())
                .build();
        return alunoService.atualizar(id, aluno, dto.getCursoId());
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        alunoService.deletar(id);
    }
}
