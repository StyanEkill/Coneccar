package com.api.Coneccar.controllers;


import com.api.Coneccar.dtos.CarroDto;
import com.api.Coneccar.dtos.UsuarioDto;
import com.api.Coneccar.model.Carro;
import com.api.Coneccar.model.User;
import com.api.Coneccar.services.CarroService;
import com.api.Coneccar.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/coneccar/carro")
public class CarroController {

    final CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid CarroDto carroDto){
        var carroModel = new Carro();
        BeanUtils.copyProperties(carroDto, carroModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(carroService.save(carroModel));
    }


}
