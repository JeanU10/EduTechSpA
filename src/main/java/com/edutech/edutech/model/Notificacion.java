package com.edutech.edutech.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;

    private String tipo; // INFO, ALERTA, RECORDATORIO

    private Long idUsuario;

    private LocalDateTime fechaEnvio;
}