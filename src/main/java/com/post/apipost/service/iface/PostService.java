package com.post.apipost.service.iface;

import com.post.apipost.dto.request.PostDtoRequest;
import com.post.apipost.dto.response.PostDtoResponse;
import com.post.apipost.exception.BadRequestException;
import com.post.apipost.models.Categorie;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostService {

    public PostDtoResponse createPost(PostDtoRequest postDtoRequest, MultipartFile imagen) throws BadRequestException;
    public List<PostDtoResponse> findAll();

    public List<PostDtoResponse> findByCategories(Long id)  throws BadRequestException;


}
