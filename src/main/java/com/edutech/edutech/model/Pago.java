package com.edutech.edutech.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idUsuario;

    private Double monto;

    private String metodo; // TARJETA, TRANSFERENCIA, PAYPAL

    private LocalDate fechaPago;

    private String estado; // COMPLETADO, PENDIENTE, FALLIDO
}