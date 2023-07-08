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

    List<CarritoDetalle> findByCarrito_EstadoAndCarritoId(boolean estado, int carrito_id);

    List<CarritoDetalle> findByCarrito_EstadoAndCarrito_Users_Id(boolean estado, int usuario_id);

    @Override
    void deleteById(Integer integer);
}