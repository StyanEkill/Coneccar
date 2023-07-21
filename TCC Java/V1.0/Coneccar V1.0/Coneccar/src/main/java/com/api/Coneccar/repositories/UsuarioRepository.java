package com.api.Coneccar.repositories;

import com.api.Coneccar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<User, UUID>{

    boolean existsByCpf (String cpf);
    boolean existsByEmail (String email);

}
