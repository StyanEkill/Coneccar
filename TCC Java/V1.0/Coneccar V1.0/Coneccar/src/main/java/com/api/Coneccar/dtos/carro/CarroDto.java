package com.api.Coneccar.dtos.carro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CarroDto {

    @NotBlank
    @Size(min = 2, max = 30)
    private String nome;

    @NotBlank
    private String fabricante;

    @NotBlank
    private String ano;

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

}
