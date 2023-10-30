package com.api.Coneccar.controllers.usuario;

import com.api.Coneccar.dtos.carro.CarroDto;
import com.api.Coneccar.dtos.usuario.DirecaoDto;
import com.api.Coneccar.model.carro.Carro;
import com.api.Coneccar.model.usuario.Direcao;
import com.api.Coneccar.services.usuario.DirecaoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/coneccar/direcao")
public class DirecaoController {

    final DirecaoService direcaoService;

    public DirecaoController(DirecaoService direcaoService) {
        this.direcaoService = direcaoService;
    }

    @PostMapping
    public ResponseEntity<Object> saveDirecao(@RequestBody @Valid DirecaoDto direcaoDto) {
        var direcaoModel = new Direcao();
        BeanUtils.copyProperties(direcaoDto, direcaoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(direcaoService.save(direcaoModel));
    }

    @GetMapping
    public ResponseEntity<List<Direcao>> getAllDirecao(){
        return ResponseEntity.status(HttpStatus.OK).body(direcaoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneDirecao(@PathVariable(value = "id") int id){
        Optional<Direcao> direcaoModelOptional = direcaoService.findById(id);
        if (!direcaoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Perfil de direção não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(direcaoModelOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDirecao(@PathVariable(value = "id") int id, @RequestBody @Valid DirecaoDto direcaoDto){
        Optional<Direcao> direcaoModelOptional = direcaoService.findById(id);
        if (!direcaoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Perfil de direção não encontrado\"");
        }
        var direcaoModel = new Direcao();
        BeanUtils.copyProperties(direcaoDto, direcaoModel);
        direcaoModel.setId(direcaoModelOptional.get().getId());
        return  ResponseEntity.status(HttpStatus.OK).body(direcaoService.save(direcaoModel));
    }



}
