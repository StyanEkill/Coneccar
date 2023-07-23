package com.api.Coneccar.controllers.usuario;

import com.api.Coneccar.dtos.usuario.UsuarioDto;
import com.api.Coneccar.model.usuario.Usuario;
import com.api.Coneccar.services.usuario.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/coneccar/usuario")
public class UsuarioController {
    final UsuarioService usuarioService;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UsuarioDto usuarioDto){
        if(usuarioService.existsByCpf(usuarioDto.getCpf())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: O Cpf já foi utilizado!!");
        }
        if(usuarioService.existsByEmail(usuarioDto.getEmail())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: O Email já foi utilizado!!");
        }
        var userModel = new Usuario();
        BeanUtils.copyProperties(usuarioDto, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(userModel));
    }
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "id") int id){
        Optional<Usuario> usuarioModelOptional = usuarioService.findById(id);
        if (!usuarioModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuarioModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") int id){
        Optional<Usuario> usuarioModelOptional = usuarioService.findById(id);
        if (!usuarioModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }
        usuarioService.delete(usuarioModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("O usuário foi deletado");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable(value = "id") int id, @RequestBody @Valid UsuarioDto usuarioDto){
        Optional<Usuario> usuarioModelOptional = usuarioService.findById(id);
        if (!usuarioModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }
        var userModel = new Usuario();
        BeanUtils.copyProperties(usuarioDto, userModel);
        userModel.setId(usuarioModelOptional.get().getId());
        return  ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(userModel));
    }

}
