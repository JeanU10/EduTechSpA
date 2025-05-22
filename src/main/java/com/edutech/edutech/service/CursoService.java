package com.edutech.edutech.service;

import com.edutech.edutech.model.Curso;

import java.util.List;

public interface CursoService {
    Curso save(Curso curso);
    List<Curso> getAll();
    Curso getById(Long id);
    void delete(Long id);
    Curso update(Long id, Curso curso);
}