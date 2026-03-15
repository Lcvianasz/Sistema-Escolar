package com.escola.sistema.service;

import com.escola.sistema.dto.AlunoDTO;
import com.escola.sistema.model.Aluno;

public class AlunoMapper {

    public static Aluno toEntity(AlunoDTO dto){
        return Aluno.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .email(dto.getEmail())
                .matricula(dto.getMatricula())
                .idade(dto.getIdade())
                .build();
    }
    public static AlunoDTO toDTO(Aluno aluno){
        return AlunoDTO.builder()
                .id(aluno.getId())
                .nome(aluno.getNome())
                .email(aluno.getEmail())
                .matricula(aluno.getMatricula())
                .idade(aluno.getIdade())
                .build();
    }
}
