package com.exemplo.universidade.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class AlunoDTO {
    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private Long cursoId; // relaciona aluno ao curso
}
