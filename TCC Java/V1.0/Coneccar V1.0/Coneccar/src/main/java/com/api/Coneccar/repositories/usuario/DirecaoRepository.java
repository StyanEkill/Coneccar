package com.api.Coneccar.repositories.usuario;

import com.api.Coneccar.model.usuario.Direcao;
import com.api.Coneccar.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DirecaoRepository extends JpaRepository<Direcao, UUID>{

    Optional<Direcao> findById(int id);
}
