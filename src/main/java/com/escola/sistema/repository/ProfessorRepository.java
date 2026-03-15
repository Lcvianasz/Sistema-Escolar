package com.escola.sistema.repository;

import com.escola.sistema.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{
}
