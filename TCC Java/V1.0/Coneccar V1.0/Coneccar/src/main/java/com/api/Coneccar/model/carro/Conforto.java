package com.api.Coneccar.model.carro;

import com.api.Coneccar.model.bases.Categoria;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Conforto")
public class Conforto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idCategoria",nullable = false)
    private Categoria categoria;

    @OneToMany(mappedBy = "conforto")
    private List<Modelo> modelos;

    @Column(nullable = false)
    private boolean valor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isValor() {
        return valor;
    }

    public void setValor(boolean valor) {
        this.valor = valor;
    }



}
