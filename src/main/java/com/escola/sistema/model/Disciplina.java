package com.escola.sistema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "disciplina")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer cargaHoraria;
    @ManyToOne
    @JoinColumn(name = "professor_id")
    @JsonIgnore
    private Professor professor;
    @OneToMany(mappedBy = "disciplina")
    @JsonIgnore
    private List<Nota> notas = new ArrayList<>();
}
