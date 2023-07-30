package com.api.Coneccar.model.bases;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TipoCategoria")
public class TipoCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idTipo",nullable = false)
    private Tipo tipo;

    @Column(nullable = false, length = 30)
    private String descricao;

    @OneToMany(mappedBy = "tipoCategorias")
    private List<Categoria> categorias;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
