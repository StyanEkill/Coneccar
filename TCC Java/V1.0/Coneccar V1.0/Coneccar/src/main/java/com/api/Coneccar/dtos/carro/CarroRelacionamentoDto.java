package com.api.Coneccar.dtos.carro;

import com.api.Coneccar.model.carro.Carro;
import com.api.Coneccar.model.carro.Mecanica;
import com.api.Coneccar.model.carro.Modelo;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public class CarroRelacionamentoDto {
    @NotNull
    private Carro carro;

    @NotNull
    private Modelo modelo;


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

}
