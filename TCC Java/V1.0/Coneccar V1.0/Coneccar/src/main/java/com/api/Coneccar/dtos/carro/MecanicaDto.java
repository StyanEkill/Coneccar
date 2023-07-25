package com.api.Coneccar.dtos.carro;

import jakarta.validation.constraints.NotBlank;

public class MecanicaDto {

    @NotBlank
    private String motorizacao;

    @NotBlank
    private String combustivel;

    @NotBlank
    private String potencia;


    private String velocidadeMaxima;


    private String consumoCidade;


    private String consumoEstrada;

    @NotBlank
    private String cambio;

    @NotBlank
    private String direcao;

    public String getMotorizacao() {
        return motorizacao;
    }

    public void setMotorizacao(String motorizacao) {
        this.motorizacao = motorizacao;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public void setVelocidadeMaxima(String velocidadeMaxima) {
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public String getConsumoCidade() {
        return consumoCidade;
    }

    public void setConsumoCidade(String consumoCidade) {
        this.consumoCidade = consumoCidade;
    }

    public String getConsumoEstrada() {
        return consumoEstrada;
    }

    public void setConsumoEstrada(String consumoEstrada) {
        this.consumoEstrada = consumoEstrada;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }
}
