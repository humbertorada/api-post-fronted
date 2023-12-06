package com.post.apipost.repository;

import com.post.apipost.dto.response.CategorieDtoResponse;
import com.post.apipost.dto.response.PostDtoResponse;
import com.post.apipost.models.Categorie;
import com.post.apipost.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
    List<PostDtoResponse> findByCategorie(Categorie categorie);
}
