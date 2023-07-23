package com.api.Coneccar.dtos.carro;

import com.api.Coneccar.model.carro.Carro;
import com.api.Coneccar.model.carro.Mecanica;
import com.api.Coneccar.model.carro.Modelo;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

public class CarroRelacionamentoDto {

    private Carro carro;

    private Modelo modelo;

    private Mecanica mecanica;

    @JsonProperty("idCarro")
    private void unpackNestedCarro(Integer idCarro) {
        this.carro = new Carro();
        carro.setId(idCarro);
    }

    @JsonProperty("idModelo")
    private void unpackNestedModelo(Integer idModelo) {
        this.modelo = new Modelo();
        modelo.setId(idModelo);
    }

    @JsonProperty("idMecanica")
    private void unpackNestedMecanica(Integer idMecanica) {
        this.mecanica  = new Mecanica();
        mecanica.setId(idMecanica);
    }


    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Mecanica getMecanica() {
        return mecanica;
    }

    public void setMecanica(Mecanica mecanica) {
        this.mecanica = mecanica;
    }
}
