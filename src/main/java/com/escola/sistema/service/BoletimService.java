package com.escola.sistema.service;

import com.escola.sistema.model.Nota;
import com.escola.sistema.dto.BoletimDTO;
import com.escola.sistema.repository.NotaRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoletimService {

    private final NotaRepository notaRepository;

    public List<BoletimDTO> buscarBoletim(Long alunoId){

        List<Nota> notas = notaRepository.findByAlunoId(alunoId);

        Map<String, List<Nota>> agrupado = notas.stream()
                .collect(Collectors.groupingBy(n -> n.getDisciplina().getNome()));

        List<BoletimDTO> boletim  = new ArrayList<>();

        for (String disciplina : agrupado.keySet()){
            List<Nota> lista = agrupado.get(disciplina);

            double media = lista.stream()
                    .mapToDouble(Nota::getValor)
                    .average()
                    .orElse(0);
            boletim.add(
                    BoletimDTO.builder()
                            .disciplina(disciplina)
                            .media(media)
                            .status(media >= 7 ? "APROVADO" : "REPROVADO")
                            .build()
            );
        }
        return boletim;
    }
}
