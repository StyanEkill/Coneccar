package com.api.Coneccar.services;

import com.api.Coneccar.model.UserModel;
import com.api.Coneccar.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    public UserModel save(UserModel userModel) {
        return userRepository.save(userModel);
    }
    public boolean existsByCpf(String cpf) {
        return userRepository.existsByCpf(cpf);
    }
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }
    public Optional<UserModel> findById(UUID id) {
        return userRepository.findById(id);
    }
    @Transactional
    public void delete(UserModel userModel) {
        userRepository.delete(userModel );
    }
}
