package com.diogoslz.marketplace.persistence.mapper;

import com.diogoslz.marketplace.domain.Purchase;
import com.diogoslz.marketplace.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class}) //usar el mapper PurchaseItemMapper
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idCompra", target = "purchaseId"), //Compra -> Purchase
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "medioPago", target = "paymentMethod"),
            @Mapping(source = "comentario", target = "comment"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "productos", target = "items") //este mappig usa PurchaseItemMapper
    })
    Purchase toPurchase(Compra compra);
    List<Purchase> toPurchases(List<Compra> compras); //usa el mapeo anterir  para crear la lista

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "cliente",ignore = true) //no se usa cliente
    })
    Compra toCompra(Purchase purchase);
}
