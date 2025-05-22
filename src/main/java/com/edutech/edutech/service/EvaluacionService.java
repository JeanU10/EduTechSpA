package com.edutech.edutech.service;

import com.edutech.edutech.model.Evaluacion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EvaluacionService {
    Evaluacion save(Evaluacion evaluacion);
    List<Evaluacion> getAll();
    Evaluacion getById(Long id);
    void delete(Long id);
    Evaluacion update(Long id, Evaluacion evaluacion);
}