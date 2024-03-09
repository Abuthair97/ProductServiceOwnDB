package dev.abu.productservice.services;

import dev.abu.productservice.exceptions.ProductNotFoundException;
import dev.abu.productservice.models.Category;
import dev.abu.productservice.models.Product;
import dev.abu.productservice.repositories.CategoryRepo;
import dev.abu.productservice.repositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepo productRepo;
    private CategoryRepo categoryRepo ;


    public ProductServiceImpl(ProductRepo productRepo,CategoryRepo categoryRepo){
        this.productRepo = productRepo;
        this.categoryRepo = categoryRepo;
    }
    @Override
    public Product createProduct(String title, String description,String category, double price, String imageUrl) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setImageUrl(imageUrl);
        product.setPrice(price);
        Category category1 = categoryRepo.findByTitle(category);
        if(category1 == null){
            Category category2 = new Category();
            category2.setTitle(category);
            category1 = category2;
        }
        product.setCategory(category1);

        return productRepo.save(product);
    }

    @Override
    public Product  updateProduct(Long id, Product product) throws ProductNotFoundException {
        Product product1 = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("There is no Product with Id :" + id));
        product1.setCategory(product.getCategory());
        product1.setDescription(product.getDescription());
        product1.setTitle(product.getTitle());
        product1.setPrice(product.getPrice());
        product1.setImageUrl(product.getImageUrl());
        return productRepo.save(product1);
    }

    @Override
    public void deleteProduct(Long id) throws ProductNotFoundException{
        if(!productRepo.existsById(id)){
            throw new ProductNotFoundException("There is no Product with Id : "+id);
        }
        productRepo.deleteById(id);
    }

    @Override
    public List<Product> getAll() throws ProductNotFoundException {
        List<Product> products = productRepo.findAll();
        if(products.isEmpty()){
            throw new ProductNotFoundException("There is no products ");
        }
        return products;
    }

    @Override
    public Product getById(Long id) {
         Product product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("There is no Product with id : "+id));
        return product;
    }

    @Override
    public List<Product> getProductByCategory(String category) throws ProductNotFoundException {
        List<Product> listOfProducts = productRepo.findProductByCategory(category);
        if(listOfProducts.isEmpty()){
            throw new ProductNotFoundException("There is no product with Category : "+category);
        }
        return listOfProducts;

    }
}
