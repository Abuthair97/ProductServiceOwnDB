package dev.abu.productservice.services;

import dev.abu.productservice.exceptions.CategoryNotFoundException;
import dev.abu.productservice.repositories.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepo categoryRepo;
    public CategoryServiceImpl(CategoryRepo categoryRepo){
        this.categoryRepo = categoryRepo;
    }
    @Override
    public List<String> getAllCategory() {
        List<String> allCategory = categoryRepo.findAllCategory();
        if(allCategory.isEmpty()){
            throw new CategoryNotFoundException("No Category Present");
        }
        return allCategory;
    }
}
