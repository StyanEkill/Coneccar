package com.api.Coneccar.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Carro")
public class Carro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 30)
    private String nome;

    @Column(nullable = false, length = 30)
    private String fabricante;

    @ManyToOne
    @JoinColumn(name = "idCarroModelo",nullable = false)
    private CarroModelo carroModelos;

    @Column(nullable = false, length = 4)
    private String ano;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public CarroModelo getCarroModelos() {
        return carroModelos;
    }

    public void setCarroModelos(CarroModelo carroModelos) {
        this.carroModelos = carroModelos;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
