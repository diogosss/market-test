package com.diogoslz.marketplace.persistence.mapper;

import com.diogoslz.marketplace.domain.Category;
import com.diogoslz.marketplace.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    //conversores mappers

    @Mappings({
        @Mapping(source="idCategoria",target = "categoryId"),
            @Mapping(source="descripcion",target = "category"),
                @Mapping(source="estado",target = "active")
    })
    Category toCategory(Categoria categoria); //convertir Catagoria a Categoria

    //conversion inversa
    @InheritInverseConfiguration //evitar realizar el mapping de nuevo esto hace el mapeo inverso
    @Mapping(target = "productos", ignore = true) //porque en Categoria hay una lista productos que no vamos a mapear
    Categoria toCategoria(Category category);
}
