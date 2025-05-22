package com.edutech.edutech;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.edutech.edutech.model.Usuario;
import com.edutech.edutech.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UsuarioServiceTest {

    @Autowired
    private UsuarioService usuarioService;

    @Test
    void crearUsuarioTest() {
        Usuario u = Usuario.builder().nombre("Jean").email("jean@mail.com").rol("ESTUDIANTE").estado("ACTIVO").build();
        Usuario guardado = usuarioService.save(u);
        assertNotNull(guardado.getId());
    }
}