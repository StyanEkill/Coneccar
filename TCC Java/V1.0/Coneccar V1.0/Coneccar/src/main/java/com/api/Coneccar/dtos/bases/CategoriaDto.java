package com.api.Coneccar.dtos.bases;

import com.api.Coneccar.model.bases.Tipo;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CategoriaDto {

    @NotNull
    private Tipo tipo;

    @NotBlank
    private String descricao;

    @JsonProperty("idTipo")
    private void unpackNestedModelo(Integer idTipo) {
        this.tipo = new Tipo();
        tipo.setId(idTipo);
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
