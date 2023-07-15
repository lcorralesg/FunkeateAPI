package com.example.funkeateapi.repository;

import com.example.funkeateapi.model.CarritoDetalle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * author = Jacko Tinoco
 *
 * */
public interface CarritoDetalleRepository extends CrudRepository<CarritoDetalle, Integer> {
    List<CarritoDetalle> findById(int id);

    List<CarritoDetalle> findByCarritoId(int carrito_id);
}
