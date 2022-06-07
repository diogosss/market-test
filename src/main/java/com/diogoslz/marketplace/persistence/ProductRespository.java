package com.diogoslz.marketplace.persistence;

import com.diogoslz.marketplace.persistence.crud.ProductoCrudRepository;
import com.diogoslz.marketplace.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //esta clase se encargfa de interactuar con la base de datos
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

    //Consulta producto en particular
    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    //guardar un producto
    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    //Eliminar un producto
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }


}
