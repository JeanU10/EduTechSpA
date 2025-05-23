package com.edutech.edutech.repository;

import com.edutech.edutech.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {

    List<Pago> findByUsuarioId(Long usuarioId);
}
