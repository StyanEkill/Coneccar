package com.api.Coneccar.repositories.bases;

import com.api.Coneccar.model.bases.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TipoRepository extends JpaRepository<Tipo, UUID> {
}
