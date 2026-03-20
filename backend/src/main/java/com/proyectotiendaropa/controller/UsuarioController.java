package com.proyectotiendaropa.controller;

import com.proyectotiendaropa.model.Usuario;
import com.proyectotiendaropa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios () {
        return usuarioService.findAll();
    }

    @PostMapping
    public Usuario crearUsuario (@RequestBody Usuario usuario) {
        return usuarioService.crearUsuario(usuario);
    }
}
