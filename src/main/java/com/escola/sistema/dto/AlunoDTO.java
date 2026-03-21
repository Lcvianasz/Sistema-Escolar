package com.escola.sistema.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlunoDTO {
    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @Email(message = "Email Inválido")
    @NotBlank(message = "Email é obrigatório")
    private String email;

    @NotBlank(message = "Matrícula é obrigatória")
    private String matricula;

    @NotNull(message = "Idade é obrigatória")
    private Integer idade;
}
