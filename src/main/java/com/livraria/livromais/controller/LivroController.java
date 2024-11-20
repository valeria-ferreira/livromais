package com.livraria.livromais.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LivroController {

    @GetMapping("/livros")
    public String livro() {
        return "livros";
    }
}
