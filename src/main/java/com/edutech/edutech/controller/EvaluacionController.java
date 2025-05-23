package com.edutech.edutech.controller;

import com.edutech.edutech.model.Evaluacion;
import com.edutech.edutech.service.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluaciones")
@CrossOrigin(origins = "*")
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;

    @GetMapping
    public List<Evaluacion> listar() {
        return evaluacionService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public Evaluacion obtener(@PathVariable Long id) {
        return evaluacionService.obtenerPorId(id);
    }

    @PostMapping
    public Evaluacion crear(@RequestBody Evaluacion evaluacion) {
        return evaluacionService.guardar(evaluacion);
    }

    @PutMapping("/{id}")
    public Evaluacion actualizar(@PathVariable Long id, @RequestBody Evaluacion evaluacion) {
        return evaluacionService.actualizar(id, evaluacion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        evaluacionService.eliminar(id);
    }
}
