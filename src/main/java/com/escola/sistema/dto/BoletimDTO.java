package com.escola.sistema.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoletimDTO {
    private String disciplina;
    private Double media;
    private String status;
}
