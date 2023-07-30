package com.api.Coneccar.model.carro;

import com.api.Coneccar.model.bases.Categoria;
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
    private List<Carro> carros;
    @ManyToOne
    @JoinColumn(name = "idMecanica",nullable = false)
    private Mecanica mecanica;

    @ManyToOne
    @JoinColumn(name = "idSeguranca",nullable = false)
    private Seguranca seguranca;

    @ManyToOne
    @JoinColumn(name = "idConforto",nullable = false)
    private Conforto conforto;

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

    public Mecanica getMecanica() {
        return mecanica;
    }

    public void setMecanica(Mecanica mecanica) {
        this.mecanica = mecanica;
    }

    public Seguranca getSeguranca() {
        return seguranca;
    }

    public void setSeguranca(Seguranca seguranca) {
        this.seguranca = seguranca;
    }

    public Conforto getConforto() {
        return conforto;
    }

    public void setConforto(Conforto conforto) {
        this.conforto = conforto;
    }
}
