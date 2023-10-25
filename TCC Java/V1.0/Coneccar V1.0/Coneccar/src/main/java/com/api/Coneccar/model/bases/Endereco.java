package com.api.Coneccar.model.bases;

import com.api.Coneccar.model.usuario.Usuario;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Endereco")
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 9)
    private String cep;
    @Column(nullable = false, length = 2)
    private String UF;
    @Column(nullable = false, length = 30)
    private String cidade;
    @Column(nullable = false, length = 30)
    private String bairro;
    @Column(nullable = false, length = 50)
    private String rua;
    @Column(nullable = false, length = 10)
    private String numero;
    @Column(nullable = true, length = 50)
    private String complemento;
    @Column(nullable = false, length = 20)
    private String servico;
    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
