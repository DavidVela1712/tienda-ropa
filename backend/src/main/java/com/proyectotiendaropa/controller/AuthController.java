package com.proyectotiendaropa.controller;

import com.proyectotiendaropa.model.Usuario;
import com.proyectotiendaropa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        boolean validarLogin = usuarioService.login(usuario);
        if(validarLogin) {
            return "OK";
        } else {
            return "ERROR";
        }
    }
}
