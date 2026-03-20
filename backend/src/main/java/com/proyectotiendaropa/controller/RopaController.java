package com.proyectotiendaropa.controller;

import com.proyectotiendaropa.model.Ropa;
import com.proyectotiendaropa.service.RopaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ropa")
public class RopaController {
    @Autowired
    private RopaService ropaService;

    @GetMapping
    public List<Ropa> obtenerRopa() {
        return ropaService.findAll();
    }
}
