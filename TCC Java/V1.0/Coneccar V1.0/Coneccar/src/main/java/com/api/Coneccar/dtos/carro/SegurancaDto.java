package com.api.Coneccar.dtos.carro;

import com.api.Coneccar.model.bases.Categoria;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public class SegurancaDto {

    @NotNull
    private Categoria categoria;

    @NotNull
    private boolean valor;

    @JsonProperty("idCategoria")
    private void unpackNestedCategoria(Integer idCategoria) {
        this.categoria = new Categoria();
        categoria.setId(idCategoria);
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isValor() {
        return valor;
    }

    public void setValor(boolean valor) {
        this.valor = valor;
    }
}
