package com.post.apipost.service.impl;

import com.post.apipost.dto.request.PostDtoRequest;
import com.post.apipost.dto.response.PostDtoResponse;
import com.post.apipost.exception.BadRequestException;
import com.post.apipost.exception.ErrorDTO;
import com.post.apipost.models.Categorie;
import com.post.apipost.models.Post;
import com.post.apipost.repository.CategorieRepository;
import com.post.apipost.repository.PostRepository;
import com.post.apipost.service.iface.PostService;
import com.post.apipost.util.ReturnResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostImpl implements PostService {
    private final PostRepository postRepository;
    private final CategorieRepository categorieRepository;

    @Autowired
    public PostImpl(PostRepository postRepository, CategorieRepository categorieRepository){
        this.postRepository = postRepository;
        this.categorieRepository = categorieRepository;
    }

    @Override
    public PostDtoResponse createPost(PostDtoRequest postDtoRequest, MultipartFile imagen) throws BadRequestException {

        if(!this.categorieRepository.existsById(postDtoRequest.categorie())){
            throw new BadRequestException(
                    ErrorDTO.builder()
                            .status(HttpStatus.BAD_REQUEST.value())
                            .message("El estado ingresado no existe")
                            .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                            .dateTime(LocalDateTime.now())
                            .build()
            );
        }
        var categorie = this.categorieRepository.getReferenceById(postDtoRequest.categorie());
        Post post = null;
        if(!imagen.isEmpty()){
            //Path directorioImagenes = Paths.get("src//main//resources//static/images");
            String rutaAbsoluta = "C://Producto//recursos";

            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//"+imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);

                post = this.postRepository.save(new Post(postDtoRequest,categorie, imagen.getOriginalFilename()));

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return ReturnResponses.responsePost(post);
    }

    @Override
    public List<PostDtoResponse> findAll() {
        return this.postRepository.findAll().stream().map(PostDtoResponse::new).toList();
    }

    @Override
    public List<PostDtoResponse> findByCategories(Long id) throws BadRequestException {
        var categorie = this.categorieRepository.getReferenceById(id);
        return this.postRepository.findByCategorie(categorie).stream().map(PostDtoResponse::new).toList();

    }


}
