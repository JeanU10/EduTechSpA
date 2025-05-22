package com.edutech.edutech.service;

import com.edutech.edutech.model.Pago;

import java.util.List;

public interface PagoService {
    Pago save(Pago pago);
    List<Pago> getAll();
    Pago getById(Long id);
    void delete(Long id);
    Pago update(Long id, Pago pago);
}