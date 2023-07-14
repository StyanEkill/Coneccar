package com.api.Coneccar.repositories;

import com.api.Coneccar.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID>{

    boolean existsByCpf (String cpf);
    boolean existsByEmail (String email);

}
