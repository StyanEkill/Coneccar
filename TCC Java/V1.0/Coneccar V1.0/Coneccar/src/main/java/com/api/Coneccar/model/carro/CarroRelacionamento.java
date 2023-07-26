package com.api.Coneccar.model.carro;

import jakarta.persistence.*;

@Entity
@Table(name = "CarroRelacionamento")
public class CarroRelacionamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idCarro",nullable = false)
    private Carro carro;

    @ManyToOne
    @JoinColumn(name = "idModelo",nullable = false)
    private Modelo modelo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
}
