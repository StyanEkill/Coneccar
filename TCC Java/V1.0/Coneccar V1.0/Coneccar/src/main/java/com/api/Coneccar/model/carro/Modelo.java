package com.api.Coneccar.model.carro;

import com.api.Coneccar.model.bases.ModeloCategoria;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Modelo")
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 30)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "idMecanica",nullable = false)
    private Mecanica mecanica;

    @OneToMany(mappedBy = "modelo")
    List<ModeloCategoria> modeloCategorias;

    @ManyToOne
    @JoinColumn(name = "idCarro",nullable = false)
    private Carro carro;

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Mecanica getMecanica() {
        return mecanica;
    }

    public void setMecanica(Mecanica mecanica) {
        this.mecanica = mecanica;
    }
}
