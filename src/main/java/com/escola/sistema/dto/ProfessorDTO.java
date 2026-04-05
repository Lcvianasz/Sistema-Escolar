package com.escola.sistema.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDTO {
    private Long id;
    private String nome;
    private String email;
    private String especialidade;
    private String telefone;
    private List<String> disciplinasNomes;
}
