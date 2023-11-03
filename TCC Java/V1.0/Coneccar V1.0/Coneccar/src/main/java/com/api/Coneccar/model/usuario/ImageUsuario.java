package com.api.Coneccar.model.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "imageUsuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descricao;
    private String tipo;
    @Lob
    @Column(name = "imagedata",length = 1000)
    private byte[] imageData;

    @OneToMany(mappedBy = "imageUsuario")
    List<Usuario> usuarios;
}
