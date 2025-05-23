package com.edutech.microservicios.model;

import jakarta.persistence.*;
        import lombok.*;

        import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "incidencias")
public class Incidencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descripcion;

    private String estado; // Ej: Abierta, En Progreso, Cerrada

    private LocalDateTime fechaReporte;

    private Long usuarioId;  // Quien reporta

    private Long tecnicoAsignadoId;  // Usuario técnico asignado
}
