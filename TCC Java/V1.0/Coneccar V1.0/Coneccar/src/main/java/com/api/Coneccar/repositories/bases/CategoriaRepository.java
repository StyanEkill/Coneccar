package com.api.Coneccar.repositories.bases;

import com.api.Coneccar.model.bases.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {
}
