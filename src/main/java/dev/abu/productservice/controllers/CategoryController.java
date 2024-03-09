package dev.abu.productservice.controllers;

import dev.abu.productservice.services.CategoryService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/Products/Categories")
    ResponseEntity<List<String>> getAllCategory(){
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(categoryService.getAllCategory(), HttpStatus.OK);
    }
}
