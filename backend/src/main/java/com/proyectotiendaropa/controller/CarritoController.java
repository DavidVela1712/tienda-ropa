package com.proyectotiendaropa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/compra")
public class CarritoController {

    @PostMapping
    public String comprar(@RequestBody List<Integer> vids) {
        return "Compra realizada";
    }
}
