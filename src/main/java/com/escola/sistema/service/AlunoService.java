package com.escola.sistema.service;

import com.escola.sistema.dto.AlunoDTO;
import com.escola.sistema.model.Aluno;
import com.escola.sistema.repository.AlunoRepository;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<AlunoDTO> listar(Pageable pageable){
        return repository.findAll(pageable)
                .map(AlunoMapper::toDTO);
    }

    public AlunoDTO buscarPorId(Long id){
        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno Não Encontrado"));
        return AlunoMapper.toDTO(aluno);
    }

    public AlunoDTO atualizar(Long id, AlunoDTO dto){
        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno Não Encontrado"));
        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setMatricula(dto.getMatricula());
        aluno.setIdade(dto.getIdade());

        return AlunoMapper.toDTO(repository.save(aluno));
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

}
