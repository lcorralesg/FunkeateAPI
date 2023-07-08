package com.example.funkeateapi.repository;

import com.example.funkeateapi.model.CarritoDetalle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 *
 * author = Jacko Tinoco
 *
 * */
public interface CarritoDetalleRepository extends CrudRepository<CarritoDetalle, Integer> {
    Optional<CarritoDetalle> findById(int id);

    List<CarritoDetalle> findByCarrito_EstadoAndCarritoId(boolean estado, int carrito_id);

    List<CarritoDetalle> findByCarrito_EstadoAndCarrito_Users_Id(boolean estado, int usuario_id);

    Optional<CarritoDetalle> findByCarritoIdAndProductoId(int carrito_id, int producto_id);

    @Override
    void deleteById(Integer integer);
}