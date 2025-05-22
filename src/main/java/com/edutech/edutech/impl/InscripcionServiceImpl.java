package com.edutech.edutech.impl;

import com.edutech.edutech.model.Inscripcion;
import com.edutech.edutech.repository.InscripcionRepository;
import com.edutech.edutech.service.InscripcionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscripcionServiceImpl implements InscripcionService {

    private final InscripcionRepository repository;

    public InscripcionServiceImpl(InscripcionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Inscripcion save(Inscripcion inscripcion) {
        return repository.save(inscripcion);
    }

    @Override
    public List<Inscripcion> getAll() {
        return repository.findAll();
    }

    @Override
    public Inscripcion getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Inscripcion update(Long id, Inscripcion inscripcion) {
        Inscripcion existente = repository.findById(id).orElse(null);
        if (existente != null) {
            existente.setIdUsuario(inscripcion.getIdUsuario());
            existente.setIdCurso(inscripcion.getIdCurso());
            existente.setFecha(inscripcion.getFecha());
            existente.setEstado(inscripcion.getEstado());
            return repository.save(existente);
        }
        return null;
    }
}