package com.api.Coneccar.controllers.carro;


import com.api.Coneccar.dtos.carro.SegurancaDto;
import com.api.Coneccar.model.carro.Seguranca;
import com.api.Coneccar.services.carro.SegurancaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/coneccar/seguranca")
public class SegurancaController {

    final SegurancaService segurancaService;

    public SegurancaController(SegurancaService segurancaService) {
        this.segurancaService = segurancaService;
    }

    @PostMapping
    public ResponseEntity<Object> saveSegranca(@RequestBody @Valid SegurancaDto segurancaDto){
        var segurancaModel = new Seguranca();
        BeanUtils.copyProperties(segurancaDto, segurancaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(segurancaService.save(segurancaModel));
    }
    @GetMapping
    public ResponseEntity<List<Seguranca>> getAllSeguranca(){
        return ResponseEntity.status(HttpStatus.OK).body(segurancaService.findAll());
    }

}
