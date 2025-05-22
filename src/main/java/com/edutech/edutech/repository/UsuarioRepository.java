package com.edutech.edutech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.edutech.edutech.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
