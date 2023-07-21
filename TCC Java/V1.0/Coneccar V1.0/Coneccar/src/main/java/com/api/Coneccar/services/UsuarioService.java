package com.api.Coneccar.services;

import com.api.Coneccar.model.User;
import com.api.Coneccar.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {
    final UsuarioRepository userRepository;
    public UsuarioService(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }
    public boolean existsByCpf(String cpf) {
        return userRepository.existsByCpf(cpf);
    }
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }
    public Optional<User> findById(UUID id) {
        return userRepository.findById(id);
    }
    @Transactional
    public void delete(User user) {
        userRepository.delete(user);
    }
}
