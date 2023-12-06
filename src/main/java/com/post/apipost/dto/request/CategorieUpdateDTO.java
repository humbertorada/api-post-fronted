package com.post.apipost.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record CategorieUpdateDTO(
        @NotNull(message = "Debe ingresar el id para actualizar la Categoría")
        Long id,
        String name,
        String description
) {
}
