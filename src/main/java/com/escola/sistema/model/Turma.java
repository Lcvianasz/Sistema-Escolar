package com.escola.sistema.model;

import jakarta.persistence.*;
import jakarta.validation.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer ano;

    @ManyToOne
    private Professor professor;
    @ManyToOne
    private Disciplina disciplina;
}
