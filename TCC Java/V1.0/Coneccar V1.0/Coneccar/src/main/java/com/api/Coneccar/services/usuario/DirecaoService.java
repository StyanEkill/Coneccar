package com.api.Coneccar.services.usuario;

import com.api.Coneccar.model.usuario.Direcao;
import com.api.Coneccar.model.usuario.Usuario;
import com.api.Coneccar.repositories.usuario.DirecaoRepository;
import com.api.Coneccar.repositories.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirecaoService {
    final DirecaoRepository direcaoRepository;
    public DirecaoService(DirecaoRepository direcaoRepository) {
        this.direcaoRepository = direcaoRepository;
    }

    @Transactional
    public Direcao save(Direcao direcao) {
        return direcaoRepository.save(direcao);
    }

    public List<Direcao> findAll() {
        return direcaoRepository.findAll();
    }

    public Optional<Direcao> findById(int id) {
        return direcaoRepository.findById(id);
    }
}
