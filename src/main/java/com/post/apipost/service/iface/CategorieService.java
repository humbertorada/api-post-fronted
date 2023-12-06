package com.post.apipost.service.iface;

import com.post.apipost.dto.request.CategorieDtoRequest;
import com.post.apipost.dto.request.CategorieUpdateDTO;
import com.post.apipost.dto.response.CategorieDtoResponse;
import com.post.apipost.exception.BadRequestException;
import com.post.apipost.models.Categorie;

import java.util.List;

public interface CategorieService {

    CategorieDtoResponse create(CategorieDtoRequest categorieDtoRequest);

    List<CategorieDtoResponse> findAll();

    CategorieDtoResponse update(CategorieUpdateDTO categorieUpdateDTO) throws BadRequestException;

    void delete(Long id) throws BadRequestException;


}
