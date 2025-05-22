package com.edutech.edutech.service;

import com.edutech.edutech.model.Inscripcion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InscripcionService {
    Inscripcion save(Inscripcion inscripcion);
    List<Inscripcion> getAll();
    Inscripcion getById(Long id);
    void delete(Long id);
    Inscripcion update(Long id, Inscripcion inscripcion);
}