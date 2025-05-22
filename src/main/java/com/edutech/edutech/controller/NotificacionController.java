package com.edutech.edutech.controller;

import com.edutech.edutech.model.Notificacion;
import com.edutech.edutech.service.NotificacionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
@CrossOrigin
public class NotificacionController {

    private final NotificacionService service;

    public NotificacionController(NotificacionService service) {
        this.service = service;
    }

    @PostMapping
    public Notificacion save(@RequestBody Notificacion notificacion) {
        return service.save(notificacion);
    }

    @GetMapping
    public List<Notificacion> list() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Notificacion get(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Notificacion update(@PathVariable Long id, @RequestBody Notificacion notificacion) {
        return service.update(id, notificacion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}