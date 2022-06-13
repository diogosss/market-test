package com.diogoslz.marketplace.persistence.mapper;

import com.diogoslz.marketplace.domain.Product;
import com.diogoslz.marketplace.persistence.entity.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-13T13:23:51-0500",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 11.0.15 (Eclipse Adoptium)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Product toProduct(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        Product product = new Product();

        if ( producto.getIdProducto() != null ) {
            product.setProductId( producto.getIdProducto() );
        }
        product.setName( producto.getNombre() );
        if ( producto.getIdCategoria() != null ) {
            product.setCategoryId( producto.getIdCategoria() );
        }
        if ( producto.getPrecioVenta() != null ) {
            product.setPrice( producto.getPrecioVenta() );
        }
        if ( producto.getCantidadStock() != null ) {
            product.setStock( producto.getCantidadStock() );
        }
        if ( producto.getEstado() != null ) {
            product.setState( producto.getEstado() );
        }
        product.setCategory( categoryMapper.toCategory( producto.getCategoria() ) );

        return product;
    }

    @Override
    public List<Product> toProducts(List<Producto> productos) {
        if ( productos == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( productos.size() );
        for ( Producto producto : productos ) {
            list.add( toProduct( producto ) );
        }

        return list;
    }

    @Override
    public Producto toProducto(Product product) {
        if ( product == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setIdProducto( product.getProductId() );
        producto.setNombre( product.getName() );
        producto.setIdCategoria( product.getCategoryId() );
        producto.setPrecioVenta( product.getPrice() );
        producto.setCantidadStock( product.getStock() );
        producto.setEstado( product.isState() );
        producto.setCategoria( categoryMapper.toCategoria( product.getCategory() ) );

        return producto;
    }
}
