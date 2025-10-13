package com.scalar.ecom.service;

import com.scalar.ecom.dtos.FakeStoreProductDto;
import com.scalar.ecom.exceptions.ProductNotFoundException;
import com.scalar.ecom.modal.Category;
import com.scalar.ecom.modal.Product;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private final RestTemplate restTemplate;
    //Note: this service will implement all apis using the FakeStore.
    FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException{
        Product product = null;
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/" + productId, FakeStoreProductDto.class);
        product = convertFakeStoreProductDtoToProduct(fakeStoreProductDtoResponseEntity.getBody());
        if(product == null){
            throw new ProductNotFoundException(productId, "Product with id " + productId + " doesn't exist.");
        }
        return product;
    }

    @Override
    public List<Product> getAllProducts(String tokenValue) {
        ResponseEntity<FakeStoreProductDto[]> fakeStoreProducts = restTemplate.getForEntity("https://fakestoreapi.com/products/", FakeStoreProductDto[].class);
        ArrayList<Product> result = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto: Objects.requireNonNull(fakeStoreProducts.getBody())){
            result.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
        return result;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {

    }

    @Override
    public Product updateProduct(Long productId) {
        return null;
    }

    @Override
    public Product replaceProduct(Long productId) {
        return null;
    }

    @Override
    public Page<Product> getProductByTiltle(String title, int pageNumber, int pageSize) {
        return null;
    }


    private static Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        if (fakeStoreProductDto == null) {
            return null;
        }

        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImgUrl(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());

        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
    }
}
