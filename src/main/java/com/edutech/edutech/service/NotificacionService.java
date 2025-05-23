package com.edutech.edutech.service;

import com.edutech.edutech.model.Notificacion;
import com.edutech.edutech.repository.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;

    public List<Notificacion> obtenerTodas() {
        return notificacionRepository.findAll();
    }

    public List<Notificacion> obtenerPorUsuarioId(Long usuarioId) {
        return notificacionRepository.findByUsuarioId(usuarioId);
    }

    public Notificacion obtenerPorId(Long id) {
        return notificacionRepository.findById(id).orElse(null);
    }

    public Notificacion guardar(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    public Notificacion actualizar(Long id, Notificacion nuevaNotificacion) {
        Notificacion existente = notificacionRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setUsuarioId(nuevaNotificacion.getUsuarioId());
            existente.setMensaje(nuevaNotificacion.getMensaje());
            existente.setLeida(nuevaNotificacion.isLeida());
            return notificacionRepository.save(existente);
        }
        return null;
    }

    public void eliminar(Long id) {
        notificacionRepository.deleteById(id);
    }
}
