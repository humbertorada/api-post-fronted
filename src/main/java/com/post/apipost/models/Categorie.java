package com.post.apipost.models;

import com.post.apipost.dto.request.CategorieDtoRequest;
import com.post.apipost.dto.request.CategorieUpdateDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "categories")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categorie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "creation_date")
    LocalDate creationDate = LocalDate.now();

    @Column(name = "update_date")
    LocalDate updateDate;

    @Column(nullable = false, length = 120, unique = true)
    String name;

    @Column(nullable = false, length = 250)
    String description;


    public Categorie(CategorieDtoRequest categorieDtoRequest) {
        this.name = categorieDtoRequest.name();
        this.description = categorieDtoRequest.description();
    }

    public void updateCategorie(CategorieUpdateDTO categorieUpdateDTO) {
        if(categorieUpdateDTO.name()!=null){
            this.name = categorieUpdateDTO.name();
        }
        if(categorieUpdateDTO.description()!=null){
            this.description = categorieUpdateDTO.description();
        }

        this.updateDate = LocalDate.now();
    }
}
