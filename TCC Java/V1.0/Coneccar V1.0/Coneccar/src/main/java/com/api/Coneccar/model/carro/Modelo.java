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
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "idMecanica",nullable = false)
    private Mecanica mecanica;

    @ManyToMany
    @JoinTable(name = "modeloCategoria",
            joinColumns = @JoinColumn(name = "idModelo"),
            inverseJoinColumns = @JoinColumn(name = "idCategoria"))
    @JoinColumn(name = "valorCategoria",nullable = false)
    List<Categoria> categorias;

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

}
