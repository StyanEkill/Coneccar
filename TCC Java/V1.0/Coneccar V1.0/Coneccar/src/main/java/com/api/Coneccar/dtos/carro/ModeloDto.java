package com.api.Coneccar.dtos.carro;

import com.api.Coneccar.model.bases.Categoria;
import com.api.Coneccar.model.carro.Conforto;
import com.api.Coneccar.model.carro.Mecanica;
import com.api.Coneccar.model.carro.Seguranca;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ModeloDto {

    @NotBlank
    private String nome;

    @NotNull
    private Mecanica mecanica;

    @NotNull
    private Seguranca seguranca;

    @NotNull
    private Conforto conforto;

    @JsonProperty("idMecanica")
    private void unpackNestedModelo(Integer idMecanica) {
        this.mecanica = new Mecanica();
        mecanica.setId(idMecanica);
    }

    @JsonProperty("idSeguranca")
    private void unpackNestedSeguranca(Integer idSeguranca) {
        this.seguranca = new Seguranca();
        seguranca.setId(idSeguranca);
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

    public Seguranca getSeguranca() {
        return seguranca;
    }

    public void setSeguranca(Seguranca seguranca) {
        this.seguranca = seguranca;
    }

    public Conforto getConforto() {
        return conforto;
    }

    public void setConforto(Conforto conforto) {
        this.conforto = conforto;
    }
}
