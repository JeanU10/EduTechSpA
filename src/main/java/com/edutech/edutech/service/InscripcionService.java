package com.edutech.edutech.service;

import com.edutech.edutech.model.Inscripcion;
import com.edutech.edutech.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    public List<Inscripcion> obtenerTodas() {
        return inscripcionRepository.findAll();
    }

    public Inscripcion obtenerPorId(Long id) {
        Optional<Inscripcion> opt = inscripcionRepository.findById(id);
        return opt.orElse(null);
    }

    public Inscripcion guardar(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    public Inscripcion actualizar(Long id, Inscripcion inscripcion) {
        Optional<Inscripcion> opt = inscripcionRepository.findById(id);
        if (opt.isPresent()) {
            Inscripcion existente = opt.get();
            existente.setUsuarioId(inscripcion.getUsuarioId());
            existente.setCursoId(inscripcion.getCursoId());
            existente.setFechaInscripcion(inscripcion.getFechaInscripcion());  // Aquí el campo correcto
            return inscripcionRepository.save(existente);
        }
        return null;
    }

    public void eliminar(Long id) {
        inscripcionRepository.deleteById(id);
    }

    // Métodos simulados para comunicación con otros servicios (por ahora solo mocks)
    public String obtenerNombreUsuario(Long usuarioId) {
        // Aquí iría la llamada real o simulación
        return "Usuario #" + usuarioId;
    }

    public String obtenerNombreCurso(Long cursoId) {
        // Aquí iría la llamada real o simulación
        return "Curso #" + cursoId;
    }

    public Inscripcion crearInscripcion(Inscripcion inscripcion) {
        // Aquí puedes hacer lógica extra antes de guardar
        return guardar(inscripcion);
    }
}
