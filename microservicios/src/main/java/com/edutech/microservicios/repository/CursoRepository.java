package com.edutech.microservicios.repository;

import com.edutech.microservicios.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
