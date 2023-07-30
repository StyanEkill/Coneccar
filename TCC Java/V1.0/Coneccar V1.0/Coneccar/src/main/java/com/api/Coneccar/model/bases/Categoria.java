package com.api.Coneccar.model.bases;

import com.api.Coneccar.model.carro.Modelo;
import com.api.Coneccar.model.carro.ModeloConfig;
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

    @Column(nullable = false, length = 30)
    private String descricao;

    @OneToOne(mappedBy = "categorias")
    private boolean valorCategoria;

    @ManyToMany(mappedBy = "categorias")
    List<Modelo> modelos;

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

    public boolean isValorCategoria() {
        return valorCategoria;
    }

    public void setValorCategoria(boolean valorCategoria) {
        this.valorCategoria = valorCategoria;
    }
}
