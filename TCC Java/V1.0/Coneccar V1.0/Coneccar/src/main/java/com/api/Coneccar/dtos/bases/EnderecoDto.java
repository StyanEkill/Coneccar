package com.api.Coneccar.dtos.bases;

import com.api.Coneccar.model.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EnderecoDto {

    @NotBlank
    @Size(max = 11)
    private String cep;

    @NotBlank
    @Size(max = 2)
    private String uf;

    @NotBlank
    private String cidade;

    @NotBlank
    private String bairro;

    @NotBlank
    private String rua;

    @NotBlank
    private String numero;

    private String complemento;

    @NotBlank
    private String servico;

    @NotNull
    private Usuario usuario;

    @JsonProperty("idUsuario")
    private void unpackNestedUsuario(Integer idUsuario) {
        this.usuario = new Usuario();
        usuario.setId(idUsuario);
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
