package com.edutech.microservicios.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    private boolean activo = true;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Contenido> contenidos;

    @Column(nullable = false)
    private Long instructorId; // Id del instructor asignado
}
