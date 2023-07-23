package com.api.Coneccar.dtos.carro;

import jakarta.validation.constraints.NotBlank;

public class ModeloDto {

    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
