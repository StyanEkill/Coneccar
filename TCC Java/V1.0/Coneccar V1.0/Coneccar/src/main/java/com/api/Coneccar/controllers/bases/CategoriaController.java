package com.api.Coneccar.controllers.bases;

import com.api.Coneccar.dtos.bases.CategoriaDto;
import com.api.Coneccar.dtos.bases.TipoDto;
import com.api.Coneccar.model.bases.Categoria;
import com.api.Coneccar.model.bases.Tipo;
import com.api.Coneccar.services.bases.CategoriaService;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/coneccar/categoria")
public class CategoriaController {


    final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<Object> saveCategoria(@RequestBody @Valid CategoriaDto categoriaDto){
        var categoriaModel = new Categoria();
        BeanUtils.copyProperties(categoriaDto, categoriaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoriaModel));
    }
    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategorias(){
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findAll());
    }

}
