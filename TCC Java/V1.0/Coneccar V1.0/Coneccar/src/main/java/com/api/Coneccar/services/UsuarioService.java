package com.api.Coneccar.services;

import com.api.Coneccar.model.Usuario;
import com.api.Coneccar.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    final UsuarioRepository usuarioRepository;
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    @Transactional
    public Usuario save(Usuario user) {
        return usuarioRepository.save(user);
    }
    public boolean existsByCpf(String cpf) {
        return usuarioRepository.existsByCpf(cpf);
    }
    public boolean existsByEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
    public Optional<Usuario> findById(int id) {
        return usuarioRepository.findById(id);
    }
    @Transactional
    public void delete(Usuario user) {
        usuarioRepository.delete(user);
    }
}
