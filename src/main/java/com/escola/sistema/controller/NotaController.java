package com.escola.sistema.controller;

import com.escola.sistema.model.Nota;
import com.escola.sistema.repository.NotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notas")
@CrossOrigin("*")
@RequiredArgsConstructor
public class NotaController {

    private final NotaRepository notaRepository;

    @GetMapping
    public List<Nota> listar() {
        return notaRepository.findAll();
    }

    @PostMapping
    public Nota criar(@RequestBody Nota nota) {
        return notaRepository.save(nota);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        notaRepository.deleteById(id);
    }
}
