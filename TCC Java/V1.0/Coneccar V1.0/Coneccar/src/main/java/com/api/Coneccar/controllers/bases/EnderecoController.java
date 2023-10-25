package com.api.Coneccar.controllers.bases;

import com.api.Coneccar.dtos.bases.EnderecoDto;
import com.api.Coneccar.model.bases.Endereco;
import com.api.Coneccar.services.bases.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/coneccar/endereco")
public class EnderecoController {
    final EnderecoService enderecoService;
    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @PostMapping
    public ResponseEntity<Object> saveEndereco(@RequestBody @Valid EnderecoDto enderecoDto) {
        if(enderecoService.existsByUsuario(enderecoDto.getUsuario())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("O usuário já possui um endereço cadastrado");
        }
        var enderecoModel = new Endereco();
        BeanUtils.copyProperties(enderecoDto, enderecoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.save(enderecoModel));
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> getAllEnderecos(){
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneEndereco(@PathVariable(value = "id") int id){
        Optional<Endereco> enderecoModelOptional = enderecoService.findById(id);
        if (!enderecoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereco não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(enderecoModelOptional.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEndereco(@PathVariable(value = "id") int id, @RequestBody @Valid EnderecoDto enderecoDto){
        Optional<Endereco> enderecoModelOptional = enderecoService.findById(id);
        if (!enderecoModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Carro não encontrado");
        }
        var enderecoModel = new Endereco();
        BeanUtils.copyProperties(enderecoDto, enderecoModel);
        enderecoModel.setId(enderecoModelOptional.get().getId());
        return  ResponseEntity.status(HttpStatus.OK).body(enderecoService.save(enderecoModel));
    }


}
