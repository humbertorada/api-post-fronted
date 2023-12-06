package com.post.apipost.dto.response;

import com.post.apipost.models.Post;

import java.time.LocalDate;

public record PostDtoResponse(
        Long id,
        String image,
        String title,
        String text,
        LocalDate creationDate,
        String categorie ) {

    public PostDtoResponse(Post post){
        this(post.getId(), post.getImage(), post.getTitle(), post.getText(),post.getCreationDate(), post.getCategorie().getName());
    }

    public PostDtoResponse(PostDtoResponse postDtoResponse) {
        this(postDtoResponse.id, postDtoResponse.image, postDtoResponse.title, postDtoResponse.text,postDtoResponse.creationDate, postDtoResponse.categorie);

    }
}

