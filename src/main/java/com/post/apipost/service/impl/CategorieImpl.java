package com.post.apipost.service.impl;

import com.post.apipost.dto.request.CategorieDtoRequest;
import com.post.apipost.dto.request.CategorieUpdateDTO;
import com.post.apipost.dto.response.CategorieDtoResponse;
import com.post.apipost.exception.BadRequestException;
import com.post.apipost.exception.ErrorDTO;
import com.post.apipost.models.Categorie;
import com.post.apipost.repository.CategorieRepository;
import com.post.apipost.service.iface.CategorieService;
import com.post.apipost.util.ReturnResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategorieImpl implements CategorieService {

   private CategorieRepository categorieRepository;

   @Autowired
   public CategorieImpl(CategorieRepository categorieRepository){
       this.categorieRepository = categorieRepository;
   }

    @Override
    public CategorieDtoResponse create(CategorieDtoRequest categorieDtoRequest) {

        var categorie = this.categorieRepository.save(new Categorie(categorieDtoRequest));

        return ReturnResponses.responseCategorie(categorie);
    }

    @Override
    public List<CategorieDtoResponse> findAll() {
        return this.categorieRepository.findAll().stream().map(CategorieDtoResponse::new).toList();
    }

    @Override
    public CategorieDtoResponse update(CategorieUpdateDTO categorieUpdateDTO) throws BadRequestException {

       if(categorieUpdateDTO.id()!=null && !this.categorieRepository.existsById(categorieUpdateDTO.id())){
            throw new BadRequestException(
                    ErrorDTO.builder()
                            .status(HttpStatus.BAD_REQUEST.value())
                            .message("El id ingresado es nulo O no pertenece a ninguna Categoría")
                            .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                            .dateTime(LocalDateTime.now())
                            .build()
            );
       }
        var categorie = this.categorieRepository.getReferenceById(categorieUpdateDTO.id());

        categorie.updateCategorie(categorieUpdateDTO);

        return ReturnResponses.responseCategorie(categorie);
    }

    @Override
    public void delete(Long id) throws BadRequestException {
        if(id!=null && !this.categorieRepository.existsById(id)){
            throw new BadRequestException(
                    ErrorDTO.builder()
                            .status(HttpStatus.BAD_REQUEST.value())
                            .message("El id ingresado es nulo O no pertenece a ninguna Categoría")
                            .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                            .dateTime(LocalDateTime.now())
                            .build()
            );
        }
        var categorie = this.categorieRepository.getReferenceById(id);
        this.categorieRepository.delete(categorie);
    }
}
