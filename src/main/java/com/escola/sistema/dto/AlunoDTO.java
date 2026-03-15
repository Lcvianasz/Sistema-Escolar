package com.escola.sistema.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlunoDTO {
    private Long id;

    private String nome;

    private String email;

    private String matricula;

    private Integer idade;
}
