package com.api.Coneccar.repositories.bases;

import com.api.Coneccar.model.bases.Endereco;
import com.api.Coneccar.model.bases.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {
    Optional<Endereco> findById(int id);
}
