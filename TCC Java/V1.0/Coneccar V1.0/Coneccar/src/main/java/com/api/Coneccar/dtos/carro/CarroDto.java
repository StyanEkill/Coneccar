package com.api.Coneccar.dtos.carro;
import com.api.Coneccar.model.carro.Modelo;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CarroDto {

    @NotBlank
    @Size(min = 2, max = 30)
    private String nome;

    @NotNull
    private Modelo modelo;

    @NotBlank
    private String fabricante;

    @NotBlank
    private String ano;

    @JsonProperty("idModelo")
    private void unpackNestedModelo(Integer idModelo) {
        this.modelo = new Modelo();
        modelo.setId(idModelo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
}
