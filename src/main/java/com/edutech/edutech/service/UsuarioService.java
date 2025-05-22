package com.edutech.edutech.service;

import com.edutech.edutech.model.Usuario;
import java.util.List;

public interface UsuarioService {
    Usuario save(Usuario usuario);
    List<Usuario> getAll();
    Usuario getById(Long id);
    void delete(Long id);
    Usuario update(Long id, Usuario usuario);
}