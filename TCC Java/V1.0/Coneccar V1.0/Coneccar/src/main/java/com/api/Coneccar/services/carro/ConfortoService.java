package com.api.Coneccar.services.carro;

import com.api.Coneccar.model.carro.Conforto;
import com.api.Coneccar.repositories.carro.ConfortoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfortoService {

    final ConfortoRepository confortoRepository;

    public ConfortoService(ConfortoRepository confortoRepository) {
        this.confortoRepository = confortoRepository;
    }

    @Transactional
    public Conforto save(Conforto confortoModel) {
        return confortoRepository.save(confortoModel);
    }

    public List<Conforto> findAll() {
        return confortoRepository.findAll();
    }
}
