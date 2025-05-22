package com.edutech.edutech.impl;

import com.edutech.edutech.model.Pago;
import com.edutech.edutech.repository.PagoRepository;
import com.edutech.edutech.service.PagoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoServiceImpl implements PagoService {

    private final PagoRepository repository;

    public PagoServiceImpl(PagoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pago save(Pago pago) {
        return repository.save(pago);
    }

    @Override
    public List<Pago> getAll() {
        return repository.findAll();
    }

    @Override
    public Pago getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Pago update(Long id, Pago pago) {
        Pago existente = repository.findById(id).orElse(null);
        if (existente != null) {
            existente.setIdUsuario(pago.getIdUsuario());
            existente.setMonto(pago.getMonto());
            existente.setMetodo(pago.getMetodo());
            existente.setFechaPago(pago.getFechaPago());
            existente.setEstado(pago.getEstado());
            return repository.save(existente);
        }
        return null;
    }
}