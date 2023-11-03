package com.api.Coneccar.controllers.usuario;

import com.api.Coneccar.services.usuario.ImageUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/coneccar/usuario/imageusuario")
public class ImageUsuarioController {

    @Autowired
    private ImageUsuarioService imageUsuarioService;

    @PostMapping
    public ResponseEntity<?> uploadImageUsuario(@RequestParam("image")MultipartFile file) throws IOException{
        String uploadImage = imageUsuarioService.uploadImageUsuario(file);
        return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
    }

    @GetMapping("/{fileId}")
    public ResponseEntity<?> downloadImage(@PathVariable int fileId){
        byte[] imageData = imageUsuarioService.downloadImageUsuario(fileId);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData);
    }

}
