package com.diogoslz.marketplace.persistence.crud;

import com.diogoslz.marketplace.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> { //clase y tipo de dato que es la clave primaria

}
