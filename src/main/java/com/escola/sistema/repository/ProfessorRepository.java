package com.escola.sistema.repository;

import com.escola.sistema.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

    Optional<Professor> findByEmail(String email);

    Optional<Professor> findByUsuarioId(Long id);

    @Query("SELECT p FROM Professor p LEFT JOIN FETCH p.disciplinas WHERE p.id = :id")
    Optional<Professor> findByIdWithDisciplinas(@Param("id") Long id);
}
