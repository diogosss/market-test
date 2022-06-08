package com.diogoslz.marketplace.domain.service;

import com.diogoslz.marketplace.domain.Product;
import com.diogoslz.marketplace.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired //iniciara la clase ProductRepository
    private ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public boolean delete(int productId){
        //productRepository.delete(productId);
        return getProduct(productId).map(pdct -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }

    //**Otra forma de borrar
    /*
    public boolean delete(int productId){
        if(getProduct(productId).isPresent()){
            productRepository.delete(productId);
        }else{
            return false;
        }
    }*/
}
