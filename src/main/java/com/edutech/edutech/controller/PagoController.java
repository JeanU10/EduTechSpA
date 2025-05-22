package com.edutech.edutech.controller;

import com.edutech.edutech.model.Pago;
import com.edutech.edutech.service.PagoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@CrossOrigin
public class PagoController {

    private final PagoService service;

    public PagoController(PagoService service) {
        this.service = service;
    }

    @PostMapping
    public Pago save(@RequestBody Pago pago) {
        return service.save(pago);
    }

    @GetMapping
    public List<Pago> list() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Pago get(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Pago update(@PathVariable Long id, @RequestBody Pago pago) {
        return service.update(id, pago);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}