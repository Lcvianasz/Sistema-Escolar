package com.escola.sistema.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LancarNotaDTO {
    private Long alunoId;
    private Long disciplinaId;
    private Integer bimestre;
    private Double valor;
    private Integer faltas;
}
