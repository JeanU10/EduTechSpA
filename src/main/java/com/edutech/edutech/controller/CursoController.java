package com.edutech.edutech.controller;

import com.edutech.edutech.model.Curso;
import com.edutech.edutech.service.CursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin
public class CursoController {

    private final CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

    @PostMapping
    public Curso save(@RequestBody Curso curso) {
        return service.save(curso);
    }

    @GetMapping
    public List<Curso> list() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Curso get(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Curso update(@PathVariable Long id, @RequestBody Curso curso) {
        return service.update(id, curso);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}