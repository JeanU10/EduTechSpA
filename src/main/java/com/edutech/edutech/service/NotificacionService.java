package com.edutech.edutech.service;

import com.edutech.edutech.model.Notificacion;

import java.util.List;

public interface NotificacionService {
    Notificacion save(Notificacion notificacion);
    List<Notificacion> getAll();
    Notificacion getById(Long id);
    void delete(Long id);
    Notificacion update(Long id, Notificacion notificacion);
}