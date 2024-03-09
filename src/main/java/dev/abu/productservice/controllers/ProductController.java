package dev.abu.productservice.controllers;


import dev.abu.productservice.Dtos.CreateProductDto;
import dev.abu.productservice.Dtos.ErrorDto;
import dev.abu.productservice.exceptions.ProductNotFoundException;
import dev.abu.productservice.models.Product;
import dev.abu.productservice.services.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

private ProductService productService;

public ProductController(ProductService productService){
    this.productService = productService;
}
    @PostMapping("/Products")
    ResponseEntity<Product> createProduct(@RequestBody CreateProductDto createProductDto){
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("desc","added Product");
    return new ResponseEntity<>(productService.createProduct(
            createProductDto.getTitle(),
            createProductDto.getDescription(),
            createProductDto.getImg(),
            createProductDto.getPrice(),
            createProductDto.getCategory()
    ), httpHeaders,HttpStatus.CREATED);
    }

    @PutMapping("/Products/{id}")
    ResponseEntity <Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
    HttpHeaders httpHeader = new HttpHeaders();
    httpHeader.add("desc" ,"Updated product with Id : "+id);
    return new ResponseEntity<>( productService.updateProduct(id,product),httpHeader,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("Products/{id}")
    ResponseEntity<Void> deleteProduct(@PathVariable  Long id) {
    HttpHeaders httpHeaders  =  new HttpHeaders() ;
    httpHeaders.add("Desc" , "Deleting Product with Id : "+id);
    productService.deleteProduct(id);
    return new ResponseEntity<>(httpHeaders,HttpStatus.OK);
    }

     @GetMapping("/Products")
     ResponseEntity<List<Product>> getAll() {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("Desc" ,"Getting all product");
    return new ResponseEntity<>(productService.getAll(),httpHeaders,HttpStatus.OK);
    }

    @GetMapping("/Products/{id}")
    ResponseEntity< Product> getById(@PathVariable Long id) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add("Desc" ,"Getting Product with Id : "+id);
    return new ResponseEntity<>(productService.getById(id),httpHeaders,HttpStatus.OK);
    }

    @GetMapping("/Products/Category/{category}")
    ResponseEntity<List<Product>> getProductByCategory(@PathVariable String category){
    HttpHeaders  httpHeaders = new HttpHeaders();
    httpHeaders.add("Desc" ,"Getting All product with Category : "+category);
    return new ResponseEntity<>(productService.getProductByCategory(category),httpHeaders,HttpStatus.OK);
    }

}
