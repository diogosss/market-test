package com.diogoslz.marketplace.persistence;

import com.diogoslz.marketplace.domain.Product;
import com.diogoslz.marketplace.domain.repository.ProductRepository;
import com.diogoslz.marketplace.persistence.crud.ProductoCrudRepository;
import com.diogoslz.marketplace.persistence.entity.Producto;
import com.diogoslz.marketplace.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository //esta clase se encargfa de interactuar con la base de datos
public class ProductRespository implements ProductRepository {

    @Autowired  //Inyeccion de dependencia para no crear objetos manualmente viola principio inyeccion dependencia
    private ProductoCrudRepository productoCrudRepository;
    @Autowired  //Inyeccion de dependencia solo usar con componentes spring
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        //return (List<Producto>) productoCrudRepository.findAll(); //recibe toda la lista de productos
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }
/*
    public List<Producto> getByCategory(int idCategoria){
        return productoCrudRepository.findByIdCategoria(idCategoria);
    }
*/

    @Override
    public Optional<List<Product>> getByCategory(int categoryId){
        List<Producto> productos =productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,true);
        //no existe un mapper para convertir una lista de opcionales
        return productos.map(prods -> mapper.toProducts(prods));
        //.map devuelve el mapeo de prods a productos como una lista Optional
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        //findByID devuelve un Optional pero hay que mappear productos a product
        return productoCrudRepository.findById(productId).map(prod -> mapper.toProduct(prod));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
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
/*
    //guardar un producto
    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }
*/

    @Override
    //Eliminar un producto
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }


}
