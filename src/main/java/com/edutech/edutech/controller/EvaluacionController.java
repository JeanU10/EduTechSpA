package com.edutech.edutech.controller;

import com.edutech.edutech.model.Evaluacion;
import com.edutech.edutech.service.EvaluacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluaciones")
@CrossOrigin
public class EvaluacionController {

    private final EvaluacionService service;

    public EvaluacionController(EvaluacionService service) {
        this.service = service;
    }

    @PostMapping
    public Evaluacion save(@RequestBody Evaluacion evaluacion) {
        return service.save(evaluacion);
    }

    @GetMapping
    public List<Evaluacion> list() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Evaluacion get(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Evaluacion update(@PathVariable Long id, @RequestBody Evaluacion evaluacion) {
        return service.update(id, evaluacion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}