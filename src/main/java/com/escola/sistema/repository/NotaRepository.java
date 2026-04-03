package com.escola.sistema.repository;

import com.escola.sistema.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotaRepository extends JpaRepository<Nota, Long>{

    List<Nota> findByAlunoId(Long alunoId);
}
