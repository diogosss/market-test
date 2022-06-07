package com.diogoslz.marketplace.persistence;

import com.diogoslz.marketplace.persistence.crud.ProductoCrudRepository;
import com.diogoslz.marketplace.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductRespository {

    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll(); //recibe toda la lista de productos
    }

    public List<Producto> getByCategory(int idCategoria){
        return productoCrudRepository.findByIdCategoria(idCategoria);
    }

    public List<Producto> getByCategoryOrder(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    //de los comentarios


}
