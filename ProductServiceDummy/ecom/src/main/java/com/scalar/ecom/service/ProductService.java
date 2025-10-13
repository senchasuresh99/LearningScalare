package com.scalar.ecom.service;


import com.scalar.ecom.exceptions.CategoryNotFoundException;
import com.scalar.ecom.exceptions.ProductAlreadyExistException;
import com.scalar.ecom.exceptions.ProductNotFoundException;
import com.scalar.ecom.modal.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productId) throws ProductNotFoundException;
    List<Product> getAllProducts(String tokenValue);
    Product createProduct(Product product) throws CategoryNotFoundException, ProductAlreadyExistException;
    void deleteProduct(Long productId);
    Product updateProduct(Long productId);
    Product replaceProduct(Long productId);

    //Pagingation & Sorting & Searching
    Page<Product> getProductByTiltle(String title, int pageNumber, int pageSize);
}
