package com.exemplo.universidade.repository;

import com.exemplo.universidade.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
