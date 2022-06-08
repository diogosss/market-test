package com.diogoslz.marketplace.domain.repository;

import com.diogoslz.marketplace.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getScarseProducts(int quantity);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}


/*Repositrio para explicar o indicar a todos los repositirios como comprotarse en terminos de producto*/
/*
* No exponer la bse de daots en la API
* Desacoplar la API a una base ded atos puntual
* No tener campos innecesarios en el API
* No mesclar idiomas en el dominio
* */