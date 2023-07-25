package com.api.Coneccar.dtos.carro;

import com.api.Coneccar.model.carro.Mecanica;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ModeloDto {

    @NotBlank
    private String nome;

    @NotNull
    private Mecanica mecanica;

    @JsonProperty("idMecanica")
    private void unpackNestedModelo(Integer idMecanica) {
        this.mecanica = new Mecanica();
        mecanica.setId(idMecanica);
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Mecanica getMecanica() {
        return mecanica;
    }

    public void setMecanica(Mecanica mecanica) {
        this.mecanica = mecanica;
    }
}
