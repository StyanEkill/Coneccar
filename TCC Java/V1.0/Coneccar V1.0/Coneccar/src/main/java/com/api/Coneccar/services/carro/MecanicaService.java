package com.api.Coneccar.services.carro;

import com.api.Coneccar.model.carro.Mecanica;
import com.api.Coneccar.repositories.carro.MecanicaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MecanicaService {

    final MecanicaRepository mecanicaRepository;

    public MecanicaService(MecanicaRepository mecanicaRepository){
        this.mecanicaRepository = mecanicaRepository;
    }
    @Transactional
    public Mecanica save(Mecanica mecanicaModel) {
        return mecanicaRepository.save(mecanicaModel);
    }
    public List<Mecanica> findAll() {
        return mecanicaRepository.findAll();
    }
}
