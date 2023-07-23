package com.api.Coneccar.model;

import jakarta.persistence.*;
import org.springframework.jdbc.core.SqlReturnType;

import java.util.List;

@Entity
@Table(name = "CarroModelo")
public class CarroModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "carroModelos")
    private List<Carro> carro;

    @Column(nullable = false, length = 30)
    private String nome;


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

    public List<Carro> getCarro() {
        return carro;
    }
    public void setCarro(List<Carro> carro) {
        this.carro = carro;
    }
}
