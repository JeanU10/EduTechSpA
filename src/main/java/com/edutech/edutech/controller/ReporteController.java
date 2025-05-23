package com.edutech.edutech.controller;

import com.edutech.edutech.model.Reporte;
import com.edutech.edutech.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reportes")
@CrossOrigin(origins = "*")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public List<Reporte> listar() {
        return reporteService.obtenerTodos();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Reporte> listarPorUsuario(@PathVariable Long usuarioId) {
        return reporteService.obtenerPorUsuarioId(usuarioId);
    }

    @GetMapping("/{id}")
    public Reporte obtener(@PathVariable Long id) {
        return reporteService.obtenerPorId(id);
    }

    @PostMapping
    public Reporte crear(@RequestBody Reporte reporte) {
        return reporteService.guardar(reporte);
    }

    @PutMapping("/{id}")
    public Reporte actualizar(@PathVariable Long id, @RequestBody Reporte reporte) {
        return reporteService.actualizar(id, reporte);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        reporteService.eliminar(id);
    }
}
