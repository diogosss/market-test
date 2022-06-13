package com.diogoslz.marketplace.persistence.mapper;

import com.diogoslz.marketplace.domain.Product;
import com.diogoslz.marketplace.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class}) //uses porque mapea category con la interfaz category maper
public interface ProductMapper {
    //conversores mappers

    @Mappings({
            @Mapping(source="idProducto",target = "productId"),
            @Mapping(source="nombre",target = "name"),
            @Mapping(source="idCategoria",target = "categoryId"),
            @Mapping(source="precioVenta",target = "price"),
            @Mapping(source="cantidadStock",target = "stock"),
            @Mapping(source="estado",target = "state"),
            @Mapping(source="categoria",target = "category")
    })
    Product toProduct(Producto producto);

    List<Product> toProducts(List<Producto> productos);

    //conversion inversa
    @InheritInverseConfiguration //evitar realizar el mapping de nuevo esto hace el mapeo inverso
    @Mapping(target = "codigoBarras", ignore = true) //porque en Producto hay una variable codigo de barras que no vamos a mapear
    Producto toProducto(Product product);
}
