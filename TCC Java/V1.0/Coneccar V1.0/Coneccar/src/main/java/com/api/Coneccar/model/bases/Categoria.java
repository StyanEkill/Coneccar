package com.api.Coneccar.model.bases;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idTipoCategoria",nullable = false)
    private TipoCategoria tipoCategorias;

    @Column(nullable = false, length = 60)
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    List<ModeloCategoria> modeloCategorias;

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

    public TipoCategoria getTipoCategorias() {
        return tipoCategorias;
    }

    public void setTipoCategorias(TipoCategoria tipoCategorias) {
        this.tipoCategorias = tipoCategorias;
    }



}
