package com.edutech.edutech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/usuarios")
    public String usuarios() {
        return "usuarios/listar"; // debes crear esta vista
    }

    @GetMapping("/cursos")
    public String cursos() {
        return "cursos/listar";
    }

    @GetMapping("/matriculas")
    public String matriculas() {
        return "matriculas/listar";
    }
}