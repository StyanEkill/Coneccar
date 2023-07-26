package com.api.Coneccar.services.bases;

import com.api.Coneccar.model.bases.Categoria;
import com.api.Coneccar.model.bases.Tipo;
import com.api.Coneccar.repositories.bases.TipoRepository;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoService {

    final TipoRepository tipoRepository;

    public TipoService(TipoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }

    @Transactional
    public Tipo save(Tipo tipo) {
        return tipoRepository.save(tipo);
    }

    public List<Tipo> findAll() {
        return tipoRepository.findAll();
    }

}
