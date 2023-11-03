package com.api.Coneccar.repositories.usuario;

import com.api.Coneccar.model.usuario.ImageUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ImageUsuarioRepository extends JpaRepository<ImageUsuario, UUID> {
        Optional<ImageUsuario> findById(int id);
}
