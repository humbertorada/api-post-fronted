package com.post.apipost.controller;

import com.post.apipost.dto.request.CategorieDtoRequest;
import com.post.apipost.dto.request.CategorieUpdateDTO;
import com.post.apipost.dto.response.CategorieDtoResponse;
import com.post.apipost.dto.response.PostDtoResponse;
import com.post.apipost.exception.BadRequestException;
import com.post.apipost.service.impl.CategorieImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
//@RequestMapping("/categories")
public class CategorieController {

    private final CategorieImpl categorie;

    @Autowired
    public CategorieController(CategorieImpl categorie){
        this.categorie= categorie;
    }

    @PostMapping("/createCategories")
    @Transactional
    //@ResponseStatus(code = HttpStatus.CREATED)
    public String create(@ModelAttribute @Valid CategorieDtoRequest categorieDtoRequest){
        this.categorie.create(categorieDtoRequest);
        return "redirect:/";
    }

    @PostMapping("/listCategories")
   // @ResponseStatus(code = HttpStatus.OK)
    public String findAll(Model model){
        List<CategorieDtoResponse> categories = this.categorie.findAll();
        model.addAttribute("categoriesFront",categories);
        return "cruduser";
    }


    @PostMapping("/formCreate")
    // @ResponseStatus(code = HttpStatus.OK)
    public String formCreate(){
        return "crudcreate";
    }

    @PostMapping("/updateCategories")
    @Transactional
    public String  update(@ModelAttribute @Valid CategorieUpdateDTO categorieUpdateDTO) throws BadRequestException {
        this.categorie.update(categorieUpdateDTO);
        return "redirect:/";

    }

    @PostMapping("/deleteCategorie")
    public String delete(@RequestParam Long id) throws BadRequestException {
        this.categorie.delete(id);
        return "redirect:/";
    }




}
