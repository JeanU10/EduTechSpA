package com.edutech.edutech.impl;

import com.edutech.edutech.model.Evaluacion;
import com.edutech.edutech.repository.EvaluacionRepository;
import com.edutech.edutech.service.EvaluacionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluacionServiceImpl implements EvaluacionService {

    private final EvaluacionRepository repository;

    public EvaluacionServiceImpl(EvaluacionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Evaluacion save(Evaluacion evaluacion) {
        return repository.save(evaluacion);
    }

    @Override
    public List<Evaluacion> getAll() {
        return repository.findAll();
    }

    @Override
    public Evaluacion getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Evaluacion update(Long id, Evaluacion evaluacion) {
        Evaluacion existente = repository.findById(id).orElse(null);
        if (existente != null) {
            existente.setTitulo(evaluacion.getTitulo());
            existente.setDescripcion(evaluacion.getDescripcion());
            existente.setTipo(evaluacion.getTipo());
            existente.setIdCurso(evaluacion.getIdCurso());
            return repository.save(existente);
        }
        return null;
    }
}