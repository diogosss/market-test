package com.diogoslz.marketplace.persistence;

import com.diogoslz.marketplace.persistence.crud.ProductoCrudRepository;
import com.diogoslz.marketplace.persistence.entity.Producto;

import java.util.List;

public class ProductRespository {

    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll(); //recibe toda la lista de productos
    }

}
