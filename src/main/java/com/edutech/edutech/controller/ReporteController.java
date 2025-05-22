package com.edutech.edutech.controller;

import com.edutech.edutech.model.Reporte;
import com.edutech.edutech.service.ReporteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
@CrossOrigin
public class ReporteController {

    private final ReporteService service;

    public ReporteController(ReporteService service) {
        this.service = service;
    }

    @PostMapping
    public Reporte save(@RequestBody Reporte reporte) {
        return service.save(reporte);
    }

    @GetMapping
    public List<Reporte> list() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Reporte get(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Reporte update(@PathVariable Long id, @RequestBody Reporte reporte) {
        return service.update(id, reporte);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}