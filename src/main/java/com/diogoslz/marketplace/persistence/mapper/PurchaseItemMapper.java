package com.diogoslz.marketplace.persistence.mapper;

import com.diogoslz.marketplace.domain.PurchaseItem;
import com.diogoslz.marketplace.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class}) //referencia a producto poruqe PurchaseItem usa internamet el mapeo de producto
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.idProducto", target="productId"), // key compuesta ComprasProducto -> PurchaseItem
            @Mapping(source = "cantidad", target="quantity"), //
            //@Mapping(source = "total", target="total"), // se puede suprimir
            @Mapping(source = "estado", target="active") //
    })
    PurchaseItem toPurchaseItem(ComprasProducto producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra", ignore = true), //valores que no se mapea pero se deben colocar para ignorar
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "id.idCompra", ignore = true) //llave compuesta no usada
    })
    ComprasProducto toComprasProducto(PurchaseItem item);
}
