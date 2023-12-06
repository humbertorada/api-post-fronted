package com.post.apipost.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.post.apipost.models.Categorie;

import java.time.LocalDate;

public record CategorieDtoResponse(
        Long id,
        @JsonProperty("creation_date")
        LocalDate creationDate,
        @JsonProperty("update_date")
        LocalDate updateDate,
        String name,
        String description
) {
        public CategorieDtoResponse(Categorie categorie) {
                this(categorie.getId(),categorie.getCreationDate(),categorie.getUpdateDate(), categorie.getName(), categorie.getDescription());
        }
}
