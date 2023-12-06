package com.post.apipost.controller;

import com.post.apipost.dto.request.PostDtoRequest;
import com.post.apipost.dto.response.CategorieDtoResponse;
import com.post.apipost.dto.response.PostDtoResponse;
import com.post.apipost.exception.BadRequestException;
import com.post.apipost.service.iface.PostService;
import com.post.apipost.service.impl.CategorieImpl;
import com.post.apipost.service.impl.PostImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

import java.util.List;


@Controller
public class PostController {
    public final PostImpl post;
    private final CategorieImpl categorie;


    @Autowired
    public PostController(PostImpl post,CategorieImpl categorie){
        this.post = post;
        this.categorie = categorie;
    }

    @PostMapping("/createPosts")
    public String createPost(@ModelAttribute @Valid PostDtoRequest postDtoRequest,
                             @RequestParam("image") MultipartFile imagen) throws BadRequestException {
        this.post.createPost(postDtoRequest, imagen);

        return "redirect:/";
    }

    @PostMapping("/formCreates")
    public String formCreate(Model model){
        List<CategorieDtoResponse> categories = this.categorie.findAll();
        model.addAttribute("categoriesList",categories);
        return "formcreate";
    }


    @GetMapping("/")
    public String index(Model model, Model model2){
        List<PostDtoResponse> posts = this.post.findAll();
        model.addAttribute("postList",posts);

        List<CategorieDtoResponse> categories = this.categorie.findAll();
        model2.addAttribute("categoriesList",categories);
        return "index";
    }

    @PostMapping("/listByCategories")
    public String listBycategorie(@RequestParam Long id, Model  model) throws BadRequestException {
        List<PostDtoResponse> posts = this.post.findByCategories(id);
        model.addAttribute("postListReload",posts);

        return "redirect:/";
    }



}
