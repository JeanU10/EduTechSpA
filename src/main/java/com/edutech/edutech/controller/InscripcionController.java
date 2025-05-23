package com.edutech.edutech.controller;

import com.edutech.edutech.model.Inscripcion;
import com.edutech.edutech.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscripciones")
@CrossOrigin(origins = "*")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @GetMapping
    public List<Inscripcion> listar() {
        return inscripcionService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inscripcion> buscarPorId(@PathVariable Long id) {
        Inscripcion inscripcion = inscripcionService.obtenerPorId(id);
        if (inscripcion != null) {
            return ResponseEntity.ok(inscripcion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Inscripcion> crearInscripcion(@RequestBody Inscripcion inscripcion) {
        String nombreUsuario = inscripcionService.obtenerNombreUsuario(inscripcion.getUsuarioId());
        String nombreCurso = inscripcionService.obtenerNombreCurso(inscripcion.getCursoId());

        System.out.println("Inscribiendo al usuario: " + nombreUsuario + " al curso: " + nombreCurso);

        Inscripcion nueva = inscripcionService.crearInscripcion(inscripcion);
        return new ResponseEntity<>(nueva, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inscripcion> actualizar(@PathVariable Long id, @RequestBody Inscripcion inscripcion) {
        Inscripcion actualizado = inscripcionService.actualizar(id, inscripcion);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        inscripcionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
