package com.api.Coneccar.controllers.carro;

import com.api.Coneccar.dtos.carro.CarroDto;
import com.api.Coneccar.model.carro.Carro;
import com.api.Coneccar.model.carro.Modelo;
import com.api.Coneccar.services.carro.CarroService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/coneccar/carro")
public class CarroController {

    final CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid CarroDto carroDto) {
        var carroModel = new Carro();
        BeanUtils.copyProperties(carroDto, carroModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(carroService.save(carroModel));
    }

    @GetMapping
    public ResponseEntity<List<Carro>> getAllCarros(){
        return ResponseEntity.status(HttpStatus.OK).body(carroService.findAll());
    }
}
