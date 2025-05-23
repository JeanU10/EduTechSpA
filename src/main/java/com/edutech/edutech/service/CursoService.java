package com.edutech.edutech.service;

import com.edutech.edutech.model.Curso;
import com.edutech.edutech.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> obtenerTodos() {
        return cursoRepository.findAll();
    }

    public Curso obtenerPorId(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    public Curso guardar(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso actualizar(Long id, Curso cursoNuevo) {
        Curso cursoExistente = cursoRepository.findById(id).orElse(null);
        if (cursoExistente != null) {
            cursoExistente.setNombre(cursoNuevo.getNombre());
            cursoExistente.setDescripcion(cursoNuevo.getDescripcion());
            cursoExistente.setCategoria(cursoNuevo.getCategoria());
            cursoExistente.setDuracionHoras(cursoNuevo.getDuracionHoras());
            return cursoRepository.save(cursoExistente);
        } else {
            return null;
        }
    }

    public void eliminar(Long id) {
        cursoRepository.deleteById(id);
    }
}
