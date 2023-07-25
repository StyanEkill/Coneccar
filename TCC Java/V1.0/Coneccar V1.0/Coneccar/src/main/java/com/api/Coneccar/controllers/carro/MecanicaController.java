package com.api.Coneccar.controllers.carro;

import com.api.Coneccar.dtos.carro.MecanicaDto;
import com.api.Coneccar.model.carro.Mecanica;
import com.api.Coneccar.services.carro.MecanicaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/coneccar/mecanica")
public class MecanicaController {

    final MecanicaService mecanicaService;

    public MecanicaController(MecanicaService mecanicaService) {
        this.mecanicaService = mecanicaService;
    }

    @PostMapping
    public ResponseEntity<Object> saveMecanica(@RequestBody @Valid MecanicaDto mecanicaDto){
        var mecanicaModel = new Mecanica();
        BeanUtils.copyProperties(mecanicaDto, mecanicaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(mecanicaService.save(mecanicaModel));
    }
    @GetMapping
    public ResponseEntity<List<Mecanica>> getAllMecanica(){
        return ResponseEntity.status(HttpStatus.OK).body(mecanicaService.findAll());
    }

}
