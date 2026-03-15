package com.escola.sistema.model;

import jakarta.persistence.*;
import jakarta.validation.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Aluno aluno;
    @ManyToOne
    private Turma turma;

}
