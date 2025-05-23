package com.edutech.edutech.service;

import com.edutech.edutech.model.Evaluacion;
import com.edutech.edutech.repository.EvaluacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluacionService {

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    public List<Evaluacion> obtenerTodas() {
        return evaluacionRepository.findAll();
    }

    public Evaluacion obtenerPorId(Long id) {
        return evaluacionRepository.findById(id).orElse(null);
    }

    public Evaluacion guardar(Evaluacion evaluacion) {
        return evaluacionRepository.save(evaluacion);
    }

    public Evaluacion actualizar(Long id, Evaluacion nuevaEvaluacion) {
        Evaluacion existente = evaluacionRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setTitulo(nuevaEvaluacion.getTitulo());
            existente.setDescripcion(nuevaEvaluacion.getDescripcion());
            existente.setPuntajeMaximo(nuevaEvaluacion.getPuntajeMaximo());
            existente.setCursoId(nuevaEvaluacion.getCursoId());
            return evaluacionRepository.save(existente);
        } else {
            return null;
        }
    }

    public void eliminar(Long id) {
        evaluacionRepository.deleteById(id);
    }
}
