package com.escola.sistema.controller;

import com.escola.sistema.dto.AlunoDTO;
import com.escola.sistema.model.Aluno;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.escola.sistema.service.AlunoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import lombok.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @Operation(summary = "Cadastrar Aluno")
    @PostMapping
    public AlunoDTO salvar(@RequestBody @Valid AlunoDTO dto){
        return alunoService.salvar(dto);
    }

    @Operation(summary = "Listar Alunos")
    @GetMapping
    public Page<AlunoDTO> listarAlunos(Pageable pageable){
        return alunoService.listar(pageable);
    }

    @Operation(summary = "Buscar Por ID")
    @GetMapping("/{id}")
    public AlunoDTO buscarPorId(@PathVariable Long id){
        return alunoService.buscarPorId(id);
    }

    @Operation(summary = "Atualizar Aluno")
    @PutMapping("/{id}")
    public AlunoDTO atualizar(@PathVariable Long id, @RequestBody @Valid AlunoDTO dto){
        return  alunoService.atualizar(id, dto);
    }

    @Operation(summary = "Deletar Aluno")
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        alunoService.deletar(id);
    }
}
