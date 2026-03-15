package com.escola.sistema.service;

import com.escola.sistema.dto.AlunoDTO;
import com.escola.sistema.model.Aluno;
import com.escola.sistema.repository.AlunoRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoDTO salvar(AlunoDTO dto){
        Aluno aluno = AlunoMapper.toEntity(dto);
        aluno = repository.save(aluno);
        return AlunoMapper.toDTO(aluno);
    }

    public List<AlunoDTO> listar(){
        return repository.findAll()
                .stream()
                .map(AlunoMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
