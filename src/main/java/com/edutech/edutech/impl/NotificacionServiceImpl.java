package com.edutech.edutech.impl;

import com.edutech.edutech.model.Notificacion;
import com.edutech.edutech.repository.NotificacionRepository;
import com.edutech.edutech.service.NotificacionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionServiceImpl implements NotificacionService {

    private final NotificacionRepository repository;

    public NotificacionServiceImpl(NotificacionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Notificacion save(Notificacion notificacion) {
        return repository.save(notificacion);
    }

    @Override
    public List<Notificacion> getAll() {
        return repository.findAll();
    }

    @Override
    public Notificacion getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Notificacion update(Long id, Notificacion notificacion) {
        Notificacion existente = repository.findById(id).orElse(null);
        if (existente != null) {
            existente.setMensaje(notificacion.getMensaje());
            existente.setTipo(notificacion.getTipo());
            existente.setIdUsuario(notificacion.getIdUsuario());
            existente.setFechaEnvio(notificacion.getFechaEnvio());
            return repository.save(existente);
        }
        return null;
    }
}