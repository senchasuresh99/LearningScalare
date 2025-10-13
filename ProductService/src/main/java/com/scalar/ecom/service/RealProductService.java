package com.scalar.ecom.service;

import com.scalar.ecom.commons.AuthCommons;
import com.scalar.ecom.exceptions.CategoryNotFoundException;
import com.scalar.ecom.exceptions.ProductAlreadyExistException;
import com.scalar.ecom.exceptions.ProductNotFoundException;
import com.scalar.ecom.modal.Category;
import com.scalar.ecom.modal.Product;
import com.scalar.ecom.repositories.CategoryRepository;
import com.scalar.ecom.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service("realProductService")
//@Primary
public class RealProductService implements ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private AuthCommons authCommons;

    public RealProductService(CategoryRepository categoryRepository, ProductRepository productRepository, AuthCommons authCommons){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.authCommons = authCommons;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isEmpty()){
            throw new ProductNotFoundException(productId, "Product with id " + productId + " doesn't exist.");
        }
        return product.get();
    }

    @Override
    public List<Product> getAllProducts(String tokenValue) {
        authCommons.validateToken(tokenValue);
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) throws CategoryNotFoundException, ProductAlreadyExistException {
        Optional<Product> getProductByTitle = productRepository.findByTitle(product.getTitle());
        if(getProductByTitle.isPresent()){
            throw new ProductAlreadyExistException("Product with title " + product.getTitle() + " is already exist.");
        }

        Category category = product.getCategory();
        if(category == null){
            throw new CategoryNotFoundException("Product can,t be created without category, Please try again later by providing category.");
        }
        //If you are not setting up the cascading need to uncomment below commented code.

        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Product updateProduct(Long productId) {
        return null;
    }

    @Override
    public Product replaceProduct(Long productId) {
        return null;
    }

    //Pagination + Sorting + Search
    @Override
    public Page<Product> getProductByTiltle(String title, int pageNumber, int pageSize) {
        return productRepository.findByTitleContainsIgnoreCase(title, PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "price")));
    }

}
