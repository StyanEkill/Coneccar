package com.api.Coneccar.controllers.carro;
import com.api.Coneccar.dtos.carro.CarroRelacionamentoDto;
import com.api.Coneccar.model.carro.CarroRelacionamento;
import com.api.Coneccar.services.carro.CarroRelacionamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/coneccar/carroRelacionamento")
public class CarroRelacionamentoController {

    final CarroRelacionamentoService carroRelacionamentoService;

    public CarroRelacionamentoController(CarroRelacionamentoService carroRelacionamentoService) {
        this.carroRelacionamentoService = carroRelacionamentoService;
    }

    @PostMapping
    public ResponseEntity<Object> saveCarroRelacionamento(@RequestBody @Valid CarroRelacionamentoDto carroRelacionamentoDto){
        var carroRelacionamentoModel = new CarroRelacionamento();
        BeanUtils.copyProperties(carroRelacionamentoDto, carroRelacionamentoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(carroRelacionamentoService.save(carroRelacionamentoModel));
    }
    @GetMapping
    public ResponseEntity<List<CarroRelacionamento>> getAllCarroRelacionamentos(){
        return ResponseEntity.status(HttpStatus.OK).body(carroRelacionamentoService.findAll());
    }

}
