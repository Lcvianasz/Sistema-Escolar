package com.escola.sistema.service;

import com.escola.sistema.dto.UsuarioDTO;
import com.escola.sistema.model.Usuario;
import  com.escola.sistema.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioDTO login(UsuarioDTO dto){
        Usuario user = usuarioRepository.findByEmail(dto.getEmail());

        if (user != null && user.getSenha().equals(dto.getSenha())){
            return UsuarioDTO.builder()
                    .id(user.getId())
                    .email(user.getEmail())
                    .role(user.getRole())
                    .build();
        }
        throw new RuntimeException("Email ou Senha Inválidas");
    }
}
