package com.post.apipost.dto.request;

import com.post.apipost.models.Categorie;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public record PostDtoRequest(
        @NotBlank(message = "Debe ingesar un titulo")
        @Size(min = 2, max = 120)
        String title,

        @NotBlank(message = "Debe ingresar el texto")
        String text,

        @NotNull(message = "Debe ingresar la categoria")
        Long categorie

) {
}
