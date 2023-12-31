package com.api.Coneccar.model.usuario;

import com.api.Coneccar.model.bases.Endereco;
import com.api.Coneccar.model.bases.ModeloCategoria;
import com.api.Coneccar.model.carro.Carro;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
    private static final long serialVersionID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 30)
    private String nome;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false, unique = true, length = 30)
    private String email;

    @Column(nullable = false, length = 30)
    private String senha;

    @Column(nullable = false, length = 3)
    private String idade;

    @Getter
    @Column(nullable = false, length = 20)
    private String genero;

    @OneToMany(mappedBy = "usuario")
    List<Endereco> enderecos;

    @OneToMany(mappedBy = "usuario")
    List<Direcao> direcoes;

    @Getter
    @ManyToOne
    @JoinColumn(name = "idImagePerfil", nullable = true)
    private ImageUsuario imageUsuario;

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public void setImageUsuario(ImageUsuario imageUsuario) {
        this.imageUsuario = imageUsuario;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
