/*
package com.diogoslz.marketplace.persistence;

import com.diogoslz.marketplace.persistence.crud.CompraCrudRepository;
import com.diogoslz.marketplace.persistence.entity.Compra;

import java.time.LocalDateTime;
import java.util.List;

public class CompraRepository {

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
}
*/