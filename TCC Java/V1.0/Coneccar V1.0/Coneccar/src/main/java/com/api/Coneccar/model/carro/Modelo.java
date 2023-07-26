package com.api.Coneccar.model.carro;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Modelo")
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 30)
    private String nome;

    @OneToMany(mappedBy = "modelo")
    private List<CarroRelacionamento> carroRelacionamentos;

    @ManyToOne
    @JoinColumn(name = "idMecanica",nullable = false)
    private Mecanica mecanica;

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

    public List<CarroRelacionamento> getCarroRelacionamentos() {
        return carroRelacionamentos;
    }

    public void setCarroRelacionamentos(List<CarroRelacionamento> carroRelacionamentos) {
        this.carroRelacionamentos = carroRelacionamentos;
    }

    public Mecanica getMecanica() {
        return mecanica;
    }

    public void setMecanica(Mecanica mecanica) {
        this.mecanica = mecanica;
    }
}
