package com.edutech.edutech.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String email;
    private String rol;
    private String estado;

    // Método necesario para Spring Security
    public String getUsername() {
        return this.email;  // O this.nombre si prefieres usar nombre para login
    }

    // Opcional: si usas password, también debe tener getPassword()
    private String password;
    public String getPassword() {
        return this.password;
    }
}
