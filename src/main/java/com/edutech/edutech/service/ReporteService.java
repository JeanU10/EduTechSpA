package com.edutech.edutech.service;

import com.edutech.edutech.model.Reporte;
import com.edutech.edutech.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    public List<Reporte> obtenerTodos() {
        return reporteRepository.findAll();
    }

    public List<Reporte> obtenerPorUsuarioId(Long usuarioId) {
        return reporteRepository.findByUsuarioId(usuarioId);
    }

    public Reporte obtenerPorId(Long id) {
        return reporteRepository.findById(id).orElse(null);
    }

    public Reporte guardar(Reporte reporte) {
        return reporteRepository.save(reporte);
    }

    public Reporte actualizar(Long id, Reporte nuevoReporte) {
        Reporte existente = reporteRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setTipo(nuevoReporte.getTipo());
            existente.setDescripcion(nuevoReporte.getDescripcion());
            existente.setFechaGeneracion(nuevoReporte.getFechaGeneracion());
            existente.setUsuarioId(nuevoReporte.getUsuarioId());
            return reporteRepository.save(existente);
        }
        return null;
    }

    public void eliminar(Long id) {
        reporteRepository.deleteById(id);
    }
}
