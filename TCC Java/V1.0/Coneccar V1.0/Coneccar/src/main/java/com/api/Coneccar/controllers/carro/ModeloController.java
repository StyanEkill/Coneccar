package com.api.Coneccar.controllers.carro;

import com.api.Coneccar.dtos.carro.ModeloDto;
import com.api.Coneccar.model.carro.Modelo;
import com.api.Coneccar.services.carro.ModeloService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/coneccar/modelo")
public class ModeloController {

    final ModeloService modeloService;

    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @PostMapping
    public ResponseEntity<Object> saveModelo(@RequestBody @Valid ModeloDto modeloDto){
        var modeloModel = new Modelo();
        BeanUtils.copyProperties(modeloDto, modeloModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(modeloService.save(modeloModel));
    }
    @GetMapping
    public ResponseEntity<List<Modelo>> getAllModelos(){
        return ResponseEntity.status(HttpStatus.OK).body(modeloService.findAll());
    }

}
