package com.api.Coneccar.dtos.carro;

import com.api.Coneccar.model.carro.Mecanica;
import com.api.Coneccar.model.carro.ModeloConfig;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ModeloDto {

    @NotBlank
    private String nome;

    @NotNull
    private Mecanica mecanica;

    @NotNull
    private ModeloConfig modeloConfig;

    @NotNull
    private Conforto conforto;

    @JsonProperty("idMecanica")
    private void unpackNestedModelo(Integer idMecanica) {
        this.mecanica = new Mecanica();
        mecanica.setId(idMecanica);
    }

    @JsonProperty("idSeguranca")
    private void unpackNestedSeguranca(Integer idSeguranca) {
        this.modeloConfig = new ModeloConfig();
        modeloConfig.setId(idSeguranca);
    }

    @JsonProperty("idConforto")
    private void unpackNestedConforto(Integer idConforto) {
        this.conforto = new Conforto();
        conforto.setId(idConforto);
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

    public ModeloConfig getSeguranca() {
        return modeloConfig;
    }

    public void setSeguranca(ModeloConfig modeloConfig) {
        this.modeloConfig = modeloConfig;
    }

    public Conforto getConforto() {
        return conforto;
    }

    public void setConforto(Conforto conforto) {
        this.conforto = conforto;
    }
}
