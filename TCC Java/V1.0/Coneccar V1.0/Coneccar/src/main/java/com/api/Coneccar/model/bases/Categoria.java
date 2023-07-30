package com.api.Coneccar.model.bases;

import com.api.Coneccar.model.carro.Conforto;
import com.api.Coneccar.model.carro.Seguranca;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idTipo",nullable = false)
    private Tipo tipo;

    @Column(nullable = false, length = 30)
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<Seguranca> segurancas;

    @OneToMany(mappedBy = "categoria")
    private List<Conforto> confortos;

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

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
