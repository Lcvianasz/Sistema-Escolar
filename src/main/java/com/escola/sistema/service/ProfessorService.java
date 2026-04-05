package com.escola.sistema.service;

import com.escola.sistema.dto.ProfessorDTO;
import com.escola.sistema.dto.LancarNotaDTO;
import com.escola.sistema.model.Professor;
import com.escola.sistema.model.Disciplina;
import com.escola.sistema.model.Nota;
import com.escola.sistema.model.Aluno;
import com.escola.sistema.repository.ProfessorRepository;
import com.escola.sistema.repository.DisciplinaRepository;
import com.escola.sistema.repository.NotaRepository;
import com.escola.sistema.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    private final DisciplinaRepository disciplinaRepository;
    private final NotaRepository notaRepository;
    private final AlunoRepository alunoRepository;

    public List<ProfessorDTO> listarTodos() {
        return professorRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ProfessorDTO buscarPorId(Long id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        return toDTO(professor);
    }

    public ProfessorDTO buscarPorEmail(String email){
        Professor professor = professorRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        return toDTO(professor);
    }

    @Transactional
    public ProfessorDTO salvar(ProfessorDTO dto){
        Professor professor = new Professor();
        professor.setNome(dto.getNome());
        professor.setEmail(dto.getEmail());
        professor.setEspecialidade(dto.getEspecialidade());
        professor.setTelefone(dto.getTelefone());

        Professor saved = professorRepository.save(professor);
        return toDTO(saved);
    }

    @Transactional
    public ProfessorDTO atualizar(Long id, ProfessorDTO dto){
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        professor.setNome(dto.getNome());
        professor.setEmail(dto.getEmail());
        professor.setEspecialidade(dto.getEspecialidade());
        professor.setTelefone(dto.getTelefone());

        Professor updated = professorRepository.save(professor);
        return toDTO(updated);
    }

    @Transactional
    public void deletar(Long id){
        professorRepository.deleteById(id);
    }

    @Transactional
    public Nota lancaNota(LancarNotaDTO dto){
        Aluno aluno = alunoRepository.findById(dto.getAlunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        Disciplina disciplina = disciplinaRepository.findById(dto.getDisciplinaId())
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

        Nota nota = Nota.builder()
                .aluno(aluno)
                .disciplina(disciplina)
                .bimestre(dto.getBimestre())
                .valor(dto.getValor())
                .faltas(dto.getFaltas() != null ? dto.getFaltas() : 0)
                .build();
        return notaRepository.save(nota);
    }
    public List<Disciplina> getDisciplinasDoProfessor(Long professorId){
        Professor professor = professorRepository.findByIdWithDisciplinas(professorId)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
        return professor.getDisciplinas();
    }
    private ProfessorDTO toDTO(Professor professor){
        List<String> disciplinasNomes = professor.getDisciplinas().stream()
                .map(Disciplina::getNome)
                .collect(Collectors.toList());
        return ProfessorDTO.builder()
                .id(professor.getId())
                .nome(professor.getNome())
                .email(professor.getEmail())
                .especialidade(professor.getEspecialidade())
                .telefone(professor.getTelefone())
                .disciplinasNomes(disciplinasNomes)
                .build();
    }
}
