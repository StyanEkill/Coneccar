package com.api.Coneccar.dtos.bases;

import com.api.Coneccar.model.bases.Categoria;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.List;


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
