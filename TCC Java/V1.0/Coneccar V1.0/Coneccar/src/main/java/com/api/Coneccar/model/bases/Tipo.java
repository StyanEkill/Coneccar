package com.api.Coneccar.model.bases;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Tipo")
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "tipo")
    private List<Categoria> categorias;

    @Column(nullable = false, length = 30)
    private String descricao;

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
