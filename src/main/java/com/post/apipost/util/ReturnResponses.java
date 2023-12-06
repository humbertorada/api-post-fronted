package com.post.apipost.util;

import com.post.apipost.dto.request.PostDtoRequest;
import com.post.apipost.dto.response.CategorieDtoResponse;
import com.post.apipost.dto.response.PostDtoResponse;
import com.post.apipost.models.Categorie;
import com.post.apipost.models.Post;

public class ReturnResponses {

    public static CategorieDtoResponse responseCategorie(Categorie categorie){
        return new CategorieDtoResponse(
                categorie.getId(),
                categorie.getCreationDate(),
                categorie.getUpdateDate(),
                categorie.getName(),
                categorie.getDescription()
        );
    }

    public static PostDtoResponse responsePost(Post post){
        return new PostDtoResponse(
                post.getId(),
                post.getImage(),
                post.getTitle(),
                post.getText(),
                post.getCreationDate(),
                post.getCategorie().getName()
        );
    }
}
