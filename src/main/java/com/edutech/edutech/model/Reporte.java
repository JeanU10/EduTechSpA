package com.edutech.edutech.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // CURSOS, USUARIOS, PAGOS

    private String descripcion;

    private LocalDateTime fechaGeneracion;
}
