package com.edutech.edutech.service;

import com.edutech.edutech.model.Reporte;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReporteService {
    Reporte save(Reporte reporte);
    List<Reporte> getAll();
    Reporte getById(Long id);
    void delete(Long id);
    Reporte update(Long id, Reporte reporte);
}