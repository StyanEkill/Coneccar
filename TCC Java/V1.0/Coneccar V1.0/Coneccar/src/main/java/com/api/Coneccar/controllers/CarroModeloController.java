package com.api.Coneccar.controllers;

import com.api.Coneccar.dtos.CarroDto;
import com.api.Coneccar.dtos.CarroModeloDto;
import com.api.Coneccar.model.Carro;
import com.api.Coneccar.model.CarroModelo;
import com.api.Coneccar.services.CarroModeloService;
import com.api.Coneccar.services.CarroService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/coneccar/carroModelo")
public class CarroModeloController {

    final CarroModeloService carroModeloService;

    public CarroModeloController(CarroModeloService carroModeloService) {
        this.carroModeloService = carroModeloService;
    }

    @PostMapping
    public ResponseEntity<Object> saveCarroModelo(@RequestBody @Valid CarroModeloDto carroModeloDto){
        var carroModeloModel = new CarroModelo();
        BeanUtils.copyProperties(carroModeloDto, carroModeloModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(carroModeloService.save(carroModeloModel));
    }
    @GetMapping
    public ResponseEntity<List<CarroModelo>> getAllCarroModelos(){
        return ResponseEntity.status(HttpStatus.OK).body(carroModeloService.findAll());
    }

}
