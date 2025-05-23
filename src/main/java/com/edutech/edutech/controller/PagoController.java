package com.edutech.edutech.controller;

import com.edutech.edutech.model.Pago;
import com.edutech.edutech.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
@CrossOrigin(origins = "*")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping
    public List<Pago> listar() {
        return pagoService.obtenerTodos();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Pago> listarPorUsuario(@PathVariable Long usuarioId) {
        return pagoService.obtenerPorUsuarioId(usuarioId);
    }

    @GetMapping("/{id}")
    public Pago obtener(@PathVariable Long id) {
        return pagoService.obtenerPorId(id);
    }

    @PostMapping
    public Pago crear(@RequestBody Pago pago) {
        return pagoService.guardar(pago);
    }

    @PutMapping("/{id}")
    public Pago actualizar(@PathVariable Long id, @RequestBody Pago pago) {
        return pagoService.actualizar(id, pago);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        pagoService.eliminar(id);
    }
}
