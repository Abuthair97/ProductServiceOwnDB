package dev.abu.productservice.services;

import dev.abu.productservice.exceptions.ProductNotFoundException;
import dev.abu.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(String title,String description,String category,double price,String imageUrl);

    Product updateProduct(Long id,Product product) throws ProductNotFoundException;

    void deleteProduct(Long id) throws ProductNotFoundException;

    List<Product> getAll() throws ProductNotFoundException;

    Product getById(Long id) throws ProductNotFoundException;



}
