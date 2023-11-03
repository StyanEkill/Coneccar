package com.api.Coneccar.services.usuario;

import com.api.Coneccar.configuration.ImageUtils;
import com.api.Coneccar.model.usuario.ImageUsuario;
import com.api.Coneccar.repositories.usuario.ImageUsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageUsuarioService {

    @Autowired
    private ImageUsuarioRepository imageUsuarioRepository;

    @Transactional
    public String uploadImageUsuario(MultipartFile file) throws IOException {
        ImageUsuario imageUsuario = imageUsuarioRepository.save(ImageUsuario.builder()
                .descricao(file.getOriginalFilename())
                .tipo(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if (imageUsuario!=null){
            return "upload de arquivo realizado com sucesso :"+file.getOriginalFilename();
        }
        return "ERRO";
    }
    @Transactional
    public byte[] downloadImageUsuario(int fileId){
        Optional<ImageUsuario> dbImageUsuario = imageUsuarioRepository.findById(fileId);
        byte[] images = ImageUtils.decompressImage(dbImageUsuario.get().getImageData());
        return images;
    }

}
