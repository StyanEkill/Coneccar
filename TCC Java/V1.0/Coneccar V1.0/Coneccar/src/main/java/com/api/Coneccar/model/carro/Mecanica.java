package com.api.Coneccar.model.carro;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Mecanica")
public class Mecanica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 30)
    private String motorizacao;

    @Column(nullable = false, length = 30)
    private String combustivel;

    @Column(nullable = false, length = 30)
    private String potencia;

    @Column(nullable = true, length = 30)
    private String velocidadeMaxima;

    @Column(nullable = true, length = 30)
    private String consumoCidade;

    @Column(nullable = true, length = 30)
    private String consumoEstrada;

    @Column(nullable = false, length = 30)
    private String cambio;
    
    @Column(nullable = false, length = 30)
    private String direcao;

    @OneToMany(mappedBy = "mecanica")
    private List<Modelo> modelos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
