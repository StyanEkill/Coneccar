package com.api.Coneccar.dtos.usuario;

import com.api.Coneccar.model.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class DirecaoDto {
    @NotBlank
    private String descricao;
    @NotBlank
    private int valorSeguranca;
    @NotBlank
    private int valorConforto;
    @NotBlank
    private int valorEconomia;
    @NotBlank
    private Usuario usuario;

    @JsonProperty("idUsuario")
    private void unpackNestedUsuario(Integer idUsuario) {
        this.usuario = new Usuario();
        usuario.setId(idUsuario);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getValorSeguranca() {
        return valorSeguranca;
    }

    public void setValorSeguranca(int valorSeguranca) {
        this.valorSeguranca = valorSeguranca;
    }

    public int getValorConforto() {
        return valorConforto;
    }

    public void setValorConforto(int valorConforto) {
        this.valorConforto = valorConforto;
    }

    public int getValorEconomia() {
        return valorEconomia;
    }

    public void setValorEconomia(int valorEconomia) {
        this.valorEconomia = valorEconomia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
