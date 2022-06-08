package com.diogoslz.marketplace.web.controller;

import com.diogoslz.marketplace.domain.Product;
import com.diogoslz.marketplace.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //garantiza a esta clase que va aser un controlado rde clase rest
@RequestMapping("/products") //
public class ProductController {
    @Autowired
    private ProductService productService ;

    @GetMapping("/all") //obteniendo info
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") int productId){
        return productService.getProduct(productId);
    }

    @GetMapping("/category/{categId}")
    public Optional<List<Product>> getByCategory(@PathVariable("categId") int categoryId){
        return productService.getByCategory(categoryId);
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int productId){
        return productService.delete(productId);
    }

}
