package com.scalar.ecom.controller;

import com.scalar.ecom.dtos.ProductResponseDto;
import com.scalar.ecom.exceptions.CategoryNotFoundException;
import com.scalar.ecom.exceptions.ProductAlreadyExistException;
import com.scalar.ecom.exceptions.ProductNotFoundException;
import com.scalar.ecom.modal.Product;
import com.scalar.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;
    //Constructor injection
    public ProductController(@Qualifier("realProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto<Product>> getSingleProduct(@PathVariable("id") Long productId) throws ProductNotFoundException{
        ProductResponseDto<Product> result = new ProductResponseDto<>("Success", productService.getSingleProduct(productId));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/")
    public ProductResponseDto<List<Product>> getAllProducts(@RequestHeader String tokenValue){
        return new ProductResponseDto<>("Success", productService.getAllProducts(tokenValue));
    }

    @GetMapping("/getByTitle")
    public ResponseEntity<Page<Product>> getProductByTitle(@RequestParam("title") String title, @RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize") int pageSize) throws ProductNotFoundException{
        return new ResponseEntity<>(productService.getProductByTiltle(title, pageNumber, pageSize), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) throws CategoryNotFoundException, ProductAlreadyExistException {
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long productId){
        productService.deleteProduct(productId);
    }

    @PatchMapping("/{id}")
    public void updateProduct(@PathVariable("id") Long productId){

    }

    @PutMapping("/{id}")
    public void replaceProduct(@PathVariable("id") Long productId){

    }

}
