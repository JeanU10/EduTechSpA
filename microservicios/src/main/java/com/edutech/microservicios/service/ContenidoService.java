package com.edutech.microservicios.service;

import com.edutech.microservicios.model.Contenido;
import com.edutech.microservicios.repository.ContenidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContenidoService {

    @Autowired
    private ContenidoRepository contenidoRepository;

    public List<Contenido> getAllContenidos() {
        return contenidoRepository.findAll();
    }

    public Optional<Contenido> getContenidoById(Long id) {
        return contenidoRepository.findById(id);
    }

    public Contenido createContenido(Contenido contenido) {
        return contenidoRepository.save(contenido);
    }

    public Contenido updateContenido(Long id, Contenido contenidoDetails) {
        Contenido contenido = contenidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Contenido no encontrado"));
        contenido.setTitulo(contenidoDetails.getTitulo());
        contenido.setDescripcion(contenidoDetails.getDescripcion());
        contenido.setUrlMaterial(contenidoDetails.getUrlMaterial());
        contenido.setCurso(contenidoDetails.getCurso());
        return contenidoRepository.save(contenido);
    }

    public void deleteContenido(Long id) {
        contenidoRepository.deleteById(id);
    }
}