package com.api.Coneccar.controllers.bases;

import com.api.Coneccar.dtos.bases.TipoDto;
import com.api.Coneccar.dtos.carro.CarroDto;
import com.api.Coneccar.model.bases.Tipo;
import com.api.Coneccar.model.carro.Carro;
import com.api.Coneccar.services.bases.TipoService;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/coneccar/tipo")
public class TipoController {


    final TipoService tipoService;

    public TipoController(TipoService tipoService) {
        this.tipoService = tipoService;
    }

    @PostMapping
    public ResponseEntity<Object> saveTipo(@RequestBody @Valid TipoDto tipoDto){
        var tipoModel = new Tipo();
        BeanUtils.copyProperties(tipoDto, tipoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoService.save(tipoModel));
    }
    @GetMapping
    public ResponseEntity<List<Tipo>> getAllTipos(){
        return ResponseEntity.status(HttpStatus.OK).body(tipoService.findAll());
    }


}
