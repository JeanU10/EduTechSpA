package com.edutech.microservicios.service;

import com.edutech.microservicios.model.Incidencia;
import com.edutech.microservicios.repository.IncidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IncidenciaService {

    @Autowired
    private IncidenciaRepository incidenciaRepository;

    public List<Incidencia> getAllIncidencias() {
        return incidenciaRepository.findAll();
    }

    public Optional<Incidencia> getIncidenciaById(Long id) {
        return incidenciaRepository.findById(id);
    }

    public Incidencia createIncidencia(Incidencia incidencia) {
        return incidenciaRepository.save(incidencia);
    }

    public Incidencia updateIncidencia(Long id, Incidencia incidenciaDetails) {
        Incidencia incidencia = incidenciaRepository.findById(id).orElseThrow(() -> new RuntimeException("Incidencia no encontrada"));
        incidencia.setTitulo(incidenciaDetails.getTitulo());
        incidencia.setDescripcion(incidenciaDetails.getDescripcion());
        incidencia.setEstado(incidenciaDetails.getEstado());
        incidencia.setFechaReporte(incidenciaDetails.getFechaReporte());
        incidencia.setUsuarioId(incidenciaDetails.getUsuarioId());
        incidencia.setTecnicoAsignadoId(incidenciaDetails.getTecnicoAsignadoId());
        return incidenciaRepository.save(incidencia);
    }

    public void deleteIncidencia(Long id) {
        incidenciaRepository.deleteById(id);
    }
}
