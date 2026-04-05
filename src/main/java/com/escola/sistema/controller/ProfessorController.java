package com.escola.sistema.controller;

import com.escola.sistema.dto.ProfessorDTO;
import com.escola.sistema.dto.LancarNotaDTO;
import com.escola.sistema.model.Disciplina;
import com.escola.sistema.model.Nota;
import com.escola.sistema.service.ProfessorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.hibernate.dialect.function.array.ArrayViaElementArgumentReturnTypeResolver;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/professores")
@RequiredArgsConstructor
@Tag(name = "Professor", description = "Endpoints para gerenciamento de professores")
public class ProfessorController {
    private final ProfessorService professorService;

    @Operation(summary = "Listar todos os professores")
    @GetMapping
    public  ResponseEntity<List<ProfessorDTO>> listarTodos(){
        return ResponseEntity.ok(professorService.listarTodos());
    }
    @Operation(summary = "Buscar professor por ID")
    @GetMapping("/{id}")
    public ResponseEntity<ProfessorDTO> buscarPorId(@PathVariable Long id) {
        ProfessorDTO professor = professorService.buscarPorId(id);
        if (professor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(professor);
    }
    @Operation(summary = "Buscar professor por email")
    @GetMapping("/email/{email}")
    public ResponseEntity<ProfessorDTO> buscarPorEmail(@PathVariable String email){
        return ResponseEntity.ok(professorService.buscarPorEmail(email));
    }
    @Operation(summary = "Cadastrar professor")
    @PostMapping
    public ResponseEntity<ProfessorDTO> salvar(@RequestBody @Valid ProfessorDTO dto){
        return ResponseEntity.ok(professorService.salvar(dto));
    }
    @Operation(summary = "Atualizar professor")
    @PutMapping("/{id}")
    public  ResponseEntity<ProfessorDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ProfessorDTO dto){
        return ResponseEntity.ok(professorService.atualizar(id, dto));
    }
    @Operation(summary = "Deletar professor")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        professorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
    @Operation(summary = "Lançar nota para aluno")
    @PostMapping("/lancar-nota")
    public ResponseEntity<Nota> lancaNota(@RequestBody @Valid LancarNotaDTO dto){
        return ResponseEntity.ok(professorService.lancaNota(dto));
    }
    @Operation(summary = "Listar disciplinas do professor")
    @GetMapping("/{id}/disciplinas")
    public ResponseEntity<List<Disciplina>> getDisciplinas(@PathVariable Long id){
        return ResponseEntity.ok(professorService.getDisciplinasDoProfessor(id));
    }
}
