package com.api.Coneccar.dtos.bases;

import jakarta.validation.constraints.NotBlank;


public class TipoDto {

    @NotBlank
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
