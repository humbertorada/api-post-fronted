package com.post.apipost.dto.request;

import javax.validation.constraints.NotBlank;

public record CategorieDtoRequest(
        @NotBlank(message = "Debe escribir el nombre de la categoria")
        String name,
        @NotBlank(message = "Debe indicar la descripcion de la categoria")
        String description
) {
}
