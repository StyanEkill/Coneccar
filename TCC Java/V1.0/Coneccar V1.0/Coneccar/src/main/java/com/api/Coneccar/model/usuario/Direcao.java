package com.api.Coneccar.model.usuario;

import com.api.Coneccar.model.usuario.Usuario;
import jakarta.persistence.*;

@Entity
@Table(name = "Direcao")
public class Direcao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 60)
    private String descricao;

    @Column(nullable = false)
    private int valorSeguranca;

    @Column(nullable = false)
    private int valorConforto;

    @Column(nullable = false)
    private int valorEconomia;

    @ManyToOne
    @JoinColumn(name = "idusuario",nullable = false)
    private Usuario usuario;

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

    public int getValorSeguranca() {
        return valorSeguranca;
    }

    public void setValorSeguranca(int valorSeguranca) {
        this.valorSeguranca = valorSeguranca;
    }

    public int getValorConforto() {
        return valorConforto;
    }

    public void setValorConforto(int valorConforto) {
        this.valorConforto = valorConforto;
    }

    public int getValorEconomia() {
        return valorEconomia;
    }

    public void setValorEconomia(int valorEconomia) {
        this.valorEconomia = valorEconomia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
