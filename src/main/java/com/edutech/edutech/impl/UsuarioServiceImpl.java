package com.edutech.edutech.impl;

import com.edutech.edutech.model.Usuario;
import com.edutech.edutech.repository.UsuarioRepository;
import com.edutech.edutech.service.UsuarioService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioServiceImpl(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public List<Usuario> getAll() {
        return repository.findAll();
    }

    @Override
    public Usuario getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Usuario update(Long id, Usuario usuario) {
        Usuario existente = repository.findById(id).orElse(null);
        if (existente != null) {
            existente.setNombre(usuario.getNombre());
            existente.setEmail(usuario.getEmail());
            existente.setRol(usuario.getRol());
            existente.setEstado(usuario.getEstado());
            return repository.save(existente);
        }
        return null;
    }
}
