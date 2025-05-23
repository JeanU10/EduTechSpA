package com.edutech.edutech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistasController {

    // Página principal menú
    @GetMapping({"/", "/menu"})
    public String menu() {
        return "menu";
    }

    // Usuarios
    @GetMapping("/usuarios")
    public String usuarios() {
        return "usuarios";
    }

    // Cursos
    @GetMapping("/cursos")
    public String cursos() {
        return "cursos";
    }

    // Inscripciones
    @GetMapping("/inscripciones")
    public String inscripciones() {
        return "inscripciones";
    }

    // Evaluaciones
    @GetMapping("/evaluaciones")
    public String evaluaciones() {
        return "evaluaciones";
    }

    // Notificaciones
    @GetMapping("/notificaciones")
    public String notificaciones() {
        return "notificaciones";
    }

    // Pagos
    @GetMapping("/pagos")
    public String pagos() {
        return "pagos";
    }

    // Reportes
    @GetMapping("/reportes")
    public String reportes() {
        return "reportes";
    }
}
