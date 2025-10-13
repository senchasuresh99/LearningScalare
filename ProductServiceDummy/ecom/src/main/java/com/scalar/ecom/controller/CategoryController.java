package com.scalar.ecom.controller;

import com.scalar.ecom.exceptions.CategoryNotFoundException;
import com.scalar.ecom.modal.Category;
import com.scalar.ecom.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/{id}")
    public Category getSingleCategory(@PathVariable("id") Long categoryid) throws CategoryNotFoundException {
        return categoryService.getSingleCategory(categoryid);
    }
}
