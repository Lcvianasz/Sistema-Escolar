package com.escola.sistema.controller;

import com.escola.sistema.dto.AlunoDTO;
import com.escola.sistema.model.Aluno;
import com.escola.sistema.service.AlunoService;
import org.springframework.web.bind.annotation.*;
import lombok.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    public AlunoDTO salvar(@RequestBody AlunoDTO dto){
        return alunoService.salvar(dto);
    }
    @GetMapping
    public List<AlunoDTO> listarAlunos(){
        return alunoService.listar();
    }
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        alunoService.deletar(id);
    }
}
