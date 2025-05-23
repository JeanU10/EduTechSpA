package com.edutech.microservicios.repository;

import com.edutech.microservicios.model.Contenido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContenidoRepository extends JpaRepository<Contenido, Long> {
}
