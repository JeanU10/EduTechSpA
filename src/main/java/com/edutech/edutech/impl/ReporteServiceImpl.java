package com.edutech.edutech.impl;

import com.edutech.edutech.model.Reporte;
import com.edutech.edutech.repository.ReporteRepository;
import com.edutech.edutech.service.ReporteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteServiceImpl implements ReporteService {

    private final ReporteRepository repository;

    public ReporteServiceImpl(ReporteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Reporte save(Reporte reporte) {
        return repository.save(reporte);
    }

    @Override
    public List<Reporte> getAll() {
        return repository.findAll();
    }

    @Override
    public Reporte getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Reporte update(Long id, Reporte reporte) {
        Reporte existente = repository.findById(id).orElse(null);
        if (existente != null) {
            existente.setTipo(reporte.getTipo());
            existente.setDescripcion(reporte.getDescripcion());
            existente.setFechaGeneracion(reporte.getFechaGeneracion());
            return repository.save(existente);
        }
        return null;
    }
}