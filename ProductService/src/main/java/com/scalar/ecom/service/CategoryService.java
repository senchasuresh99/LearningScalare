package com.scalar.ecom.service;

import com.scalar.ecom.exceptions.CategoryNotFoundException;
import com.scalar.ecom.modal.Category;
import com.scalar.ecom.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    public Category getSingleCategory(Long categoryid) throws CategoryNotFoundException {
        Optional<Category> category = categoryRepository.findById(categoryid);
        if(category.isEmpty()){
            throw new CategoryNotFoundException("Given category id "+ categoryid +" does not exist.");
        }
        return category.get();
    }
}
