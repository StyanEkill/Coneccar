package com.api.Coneccar.repositories;

import com.api.Coneccar.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID>{

    boolean existsByCpf (String cpf);
    boolean existsByEmail (String email);
    Optional<Usuario> findById(int id);
}
