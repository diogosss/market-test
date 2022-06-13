
package com.diogoslz.marketplace.persistence.crud;

import com.diogoslz.marketplace.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {  ///<Entity , clave primaria>

    Optional<List<Compra>> findByIdCliente(String idCliente);

    /*
    //de los comentarios
    List<Compra> findByIdClienteOrderByIdCompraAsc(int idCliente);
    List<Compra> findByFecha(LocalDateTime fecha);
    List<Compra> findByFechaAndIdClienteOrderByIdCliente(LocalDateTime fecha, int idCliente);
    List<Compra> findByFechaAndIdCLienteAndMedioPagoOrderByFechaAsc(LocalDateTime fecha, int idCliente, String medioPago);

     */

}

