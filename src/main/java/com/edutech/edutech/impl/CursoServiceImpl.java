package com.edutech.edutech.impl;

import com.edutech.edutech.model.Curso;
import com.edutech.edutech.repository.CursoRepository;
import com.edutech.edutech.service.CursoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository repository;

    public CursoServiceImpl(CursoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Curso save(Curso curso) {
        return repository.save(curso);
    }

    @Override
    public List<Curso> getAll() {
        return repository.findAll();
    }

    @Override
    public Curso getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Curso update(Long id, Curso curso) {
        Curso existente = repository.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombre(curso.getNombre());
            existente.setDescripcion(curso.getDescripcion());
            existente.setCategoria(curso.getCategoria());
            existente.setEstado(curso.getEstado());
            return repository.save(existente);
        }
        return null;
    }
}