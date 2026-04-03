package com.escola.sistema.controller;

import com.escola.sistema.dto.UsuarioDTO;
import com.escola.sistema.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody UsuarioDTO dto) {
        return ResponseEntity.ok(usuarioService.login(dto));
    }
}
