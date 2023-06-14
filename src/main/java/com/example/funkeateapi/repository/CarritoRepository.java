package com.example.funkeateapi.repository;

import com.example.funkeateapi.model.Carrito;
import com.example.funkeateapi.model.Categoria;
import com.example.funkeateapi.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * author = Jacko Tinoco
 *
 * */
public interface CarritoRepository extends CrudRepository<Carrito, Integer> {
    List<Carrito> findById(int id);

    List<Carrito> findByUsersId(int usuario_id);

    List<Carrito> getAllByEstadoTrue();
    @Override
    void deleteById(Integer integer);

    boolean existsByUsersIdAndEstadoIsTrue(int users_id);
}
