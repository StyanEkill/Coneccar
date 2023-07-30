package com.api.Coneccar.model.carro;

import com.api.Coneccar.model.bases.Categoria;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ModeloConfiguracao")
public class ModeloConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
