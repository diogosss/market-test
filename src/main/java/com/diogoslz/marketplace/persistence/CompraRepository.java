
package com.diogoslz.marketplace.persistence;

import com.diogoslz.marketplace.domain.Purchase;
import com.diogoslz.marketplace.domain.repository.PurchaseRepository;
import com.diogoslz.marketplace.persistence.crud.CompraCrudRepository;
import com.diogoslz.marketplace.persistence.entity.Compra;
import com.diogoslz.marketplace.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository //esta clase se encarga de interactuar con la base de datos
public class CompraRepository implements PurchaseRepository {

    @Autowired
    private CompraCrudRepository compraCrudRepository;

    //inyectar el mapper
    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }




    /*
    public CompraCrudRepository compraCrudRepository;

    //obtener todas las compras de un cliente
    public List<Compra> getByIdCliente(int idCliente){
        return compraCrudRepository.findByIdClienteOrderByIdCompraAsc(idCliente);
    }

    //obtener todas las ventas de una fecha
    public List<Compra> getByFechaCOmpra(LocalDateTime fecha){
        return compraCrudRepository.findByFecha(fecha);
    }

    //obtenr todas las ventas de un cliente de una fecha
    public List<Compra> getByFechaCompra(LocalDateTime fecha, int idCliente){
        return compraCrudRepository.findByFechaAndIdClienteOrderByIdCliente(fecha, idCliente);
    }

    //Obtener todas las ventas de un cliene de ua fecha con un determinado tipo de pago
    public List<Compra> getByFechaCompra(LocalDateTime fecha, int idCliente, String medioPAgo){
        return compraCrudRepository.findByFechaAndIdCLienteAndMedioPagoOrderByFechaAsc(fecha,idCliente,medioPAgo);
    }

     */
}
