package com.edutech.edutech.controller;

import com.edutech.edutech.model.Inscripcion;
import com.edutech.edutech.service.InscripcionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
@CrossOrigin
public class InscripcionController {

    private final InscripcionService service;

    public InscripcionController(InscripcionService service) {
        this.service = service;
    }

    @PostMapping
    public Inscripcion save(@RequestBody Inscripcion inscripcion) {
        return service.save(inscripcion);
    }

    @GetMapping
    public List<Inscripcion> list() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Inscripcion get(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Inscripcion update(@PathVariable Long id, @RequestBody Inscripcion inscripcion) {
        return service.update(id, inscripcion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}