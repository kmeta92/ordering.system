package com.example.ordering.system.service;

import com.example.ordering.system.model.Product;
import com.example.ordering.system.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> getProductsList(){
        return getProductsList();
    }

    public List<Product> getCategoriesList(){
        return getCategoriesList();
    }

    public Product getProduct(Integer productId) {

        Optional<Product> product = productsRepository.findById(productId);
        if(!product.isPresent()){
            throw new RuntimeException("Product not found!");
        }
        return product.get();
    }

    public void createOrUpdateProduct(Product product) {
        if (null == product.getId()) {
            createProduct(product);
            return;
        }
        updateProduct(product);
    }

    private void createProduct(Product product){
        productsRepository.save(product);
    }

    private void updateProduct(Product product){
        productsRepository.save(product);
    }

    private void deleteProduct(Integer productId){
        productsRepository.deactivateProduct(productId);
    }
}
