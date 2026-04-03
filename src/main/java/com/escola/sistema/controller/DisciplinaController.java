package com.escola.sistema.controller;

import com.escola.sistema.model.Disciplina;
import com.escola.sistema.service.DisciplinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplinas")
@CrossOrigin("*")
@RequiredArgsConstructor
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    @GetMapping
    public List<Disciplina> listar(){
        return disciplinaService.listar();
    }

    @PostMapping
    public Disciplina criar(@RequestBody Disciplina disciplina){
        return disciplinaService.salvar(disciplina);
    }

    @GetMapping("/{id}")
    public Disciplina buscar(@PathVariable Long id){
        return disciplinaService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        disciplinaService.deletar(id);
    }

    @PutMapping("/{id}")
    public Disciplina atualizar(@PathVariable Long id, @RequestBody Disciplina disciplina) {
        Disciplina existente = disciplinaService.buscarPorId(id);

        existente.setNome(disciplina.getNome());
        existente.setCargaHoraria(disciplina.getCargaHoraria());

        return disciplinaService.salvar(existente);
    }
}
