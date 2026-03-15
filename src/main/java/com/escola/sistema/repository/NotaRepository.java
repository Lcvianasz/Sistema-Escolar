package com.escola.sistema.repository;

import com.escola.sistema.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotaRepository extends JpaRepository<Nota, Long>{
}
