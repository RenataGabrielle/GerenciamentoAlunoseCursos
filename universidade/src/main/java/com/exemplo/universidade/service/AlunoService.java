package com.exemplo.universidade.service;

import com.exemplo.universidade.entity.Aluno;
import com.exemplo.universidade.entity.Curso;
import com.exemplo.universidade.exception.ResourceNotFoundException;
import com.exemplo.universidade.repository.AlunoRepository;
import com.exemplo.universidade.repository.CursoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public AlunoService(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    public Aluno salvar(Aluno aluno, Long cursoId) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com id: " + cursoId));
        aluno.setCurso(curso);
        return alunoRepository.save(aluno);
    }

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    public Aluno buscarPorId(Long id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não encontrado com id: " + id));
    }

    public Aluno atualizar(Long id, Aluno alunoAtualizado, Long cursoId) {
        Aluno aluno = buscarPorId(id);
        aluno.setNome(alunoAtualizado.getNome());
        aluno.setEmail(alunoAtualizado.getEmail());
        aluno.setDataNascimento(alunoAtualizado.getDataNascimento());
        if (cursoId != null) {
            Curso curso = cursoRepository.findById(cursoId)
                    .orElseThrow(() -> new ResourceNotFoundException("Curso não encontrado com id: " + cursoId));
            aluno.setCurso(curso);
        }
        return alunoRepository.save(aluno);
    }

    public void deletar(Long id) {
        Aluno aluno = buscarPorId(id);
        alunoRepository.delete(aluno);
    }
}
