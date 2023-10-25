package com.api.Coneccar.services.bases;

import com.api.Coneccar.model.bases.Endereco;
import com.api.Coneccar.model.usuario.Usuario;
import com.api.Coneccar.repositories.bases.EnderecoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    @Transactional
    public Endereco save(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public List<Endereco> findAll() {
        return  enderecoRepository.findAll();
    }

    public Optional<Endereco> findById(int id) {
        return enderecoRepository.findById(id);
    }

    public boolean existsByUsuario(Usuario usuario) {
        return enderecoRepository.existsByUsuario(usuario);
    }
}
