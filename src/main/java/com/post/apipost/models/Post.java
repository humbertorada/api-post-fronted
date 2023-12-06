package com.post.apipost.models;

import com.post.apipost.dto.request.PostDtoRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "posts")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String image;

    @Column
    String title;

    @Column
    String text;

    @Column(name = "creation_date")
    LocalDate creationDate = LocalDate.now();

    @ManyToOne(fetch = FetchType.LAZY)
    Categorie categorie;


    public Post(PostDtoRequest postDtoRequest, Categorie categorie, String imagen) {
        this.image = imagen;
        this.title = postDtoRequest.title();
        this.text = postDtoRequest.text();
        this.categorie = categorie;
    }
}
