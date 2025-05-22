package com.edutech.edutech.service;

import com.edutech.edutech.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UsuarioService {
    Usuario save(Usuario usuario);
    List<Usuario> getAll();
    Usuario getById(Long id);
    void delete(Long id);
    Usuario update(Long id, Usuario usuario);

    Usuario guardarUsuario(Usuario usuario);

    Optional<Usuario> buscarPorUsername(String username);
}