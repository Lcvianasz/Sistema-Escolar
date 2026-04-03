package com.escola.sistema.service;

import com.escola.sistema.model.Disciplina;
import com.escola.sistema.repository.DisciplinaRepository;
import com.sun.source.tree.BreakTree;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    public List<Disciplina> listar() {
        return disciplinaRepository.findAll();
    }

    public Disciplina salvar(Disciplina disciplina){
        return disciplinaRepository.save(disciplina);
    }

    public Disciplina buscarPorId(Long id) {
        return disciplinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));
    }

    public void deletar(Long id){
        disciplinaRepository.deleteById(id);
    }
}
