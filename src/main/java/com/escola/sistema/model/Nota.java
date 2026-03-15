package com.escola.sistema.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  Double valor;
    private Integer bimestre;
    @ManyToOne
    private Aluno aluno;
    @ManyToOne
    private Disciplina disciplina;
}
