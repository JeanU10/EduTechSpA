package com.edutech.edutech.service;

import com.edutech.edutech.model.Pago;
import com.edutech.edutech.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public List<Pago> obtenerTodos() {
        return pagoRepository.findAll();
    }

    public List<Pago> obtenerPorUsuarioId(Long usuarioId) {
        return pagoRepository.findByUsuarioId(usuarioId);
    }

    public Pago obtenerPorId(Long id) {
        return pagoRepository.findById(id).orElse(null);
    }

    public Pago guardar(Pago pago) {
        return pagoRepository.save(pago);
    }

    public Pago actualizar(Long id, Pago nuevoPago) {
        Pago existente = pagoRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setUsuarioId(nuevoPago.getUsuarioId());
            existente.setMonto(nuevoPago.getMonto());
            existente.setFechaPago(nuevoPago.getFechaPago());
            existente.setMetodoPago(nuevoPago.getMetodoPago());
            return pagoRepository.save(existente);
        }
        return null;
    }

    public void eliminar(Long id) {
        pagoRepository.deleteById(id);
    }
}
