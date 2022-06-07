package com.diogoslz.marketplace.persistence.crud;

import com.diogoslz.marketplace.persistence.entity.Compra;
import com.diogoslz.marketplace.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> { //clase y tipo de dato de la clave primaria

    //recuperar toda lista productos de un acategoria
    //idCategoria-> IdCategoria
    //@Query(value = "SELECT * FROM productos WHERE id_categoria = ?",nativeQuery = true)
    List<Producto> findByIdCategoria(int idCategoria);

    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);



}
