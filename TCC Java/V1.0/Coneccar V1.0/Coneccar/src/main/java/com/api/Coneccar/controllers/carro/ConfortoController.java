package com.api.Coneccar.controllers.carro;

import com.api.Coneccar.dtos.carro.CarroDto;
import com.api.Coneccar.dtos.carro.ConfortoDto;
import com.api.Coneccar.model.carro.Carro;
import com.api.Coneccar.model.carro.Conforto;
import com.api.Coneccar.services.carro.ConfortoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/coneccar/conforto")
public class ConfortoController {

    final ConfortoService confortoService;

    public ConfortoController(ConfortoService confortoService) {
        this.confortoService = confortoService;
    }

    @PostMapping
    public ResponseEntity<Object> saveConforto(@RequestBody @Valid ConfortoDto confortoDto){
        var confortoModel = new Conforto();
        BeanUtils.copyProperties(confortoDto, confortoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(confortoService.save(confortoModel));
    }
    @GetMapping
    public ResponseEntity<List<Conforto>> getAllConforto(){
        return ResponseEntity.status(HttpStatus.OK).body(confortoService.findAll());
    }

}
