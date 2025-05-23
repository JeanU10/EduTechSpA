package com.edutech.microservicios.model;

import jakarta.persistence.*;
        import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private String nombreCompleto;

    private String email;

    private String rol;  // ADMIN, GERENTE, INSTRUCTOR, SOPORTE, CLIENTE

    private boolean activo = true;
}
