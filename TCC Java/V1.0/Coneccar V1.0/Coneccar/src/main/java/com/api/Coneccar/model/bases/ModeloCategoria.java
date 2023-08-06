package com.api.Coneccar.model.bases;

import com.api.Coneccar.model.carro.Modelo;
import jakarta.persistence.*;


@Entity
@Table(name = "ModeloCategoria")
public class ModeloCategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idModelo",nullable = false)
    private Modelo modelo;

    @ManyToOne
    @JoinColumn(name = "idCategoria",nullable = false)
    private Categoria categoria;

    @Column(nullable = false)
    private boolean valorCategoria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isValorCategoria() {
        return valorCategoria;
    }

    public void setValorCategoria(boolean valorCategoria) {
        this.valorCategoria = valorCategoria;
    }
}
