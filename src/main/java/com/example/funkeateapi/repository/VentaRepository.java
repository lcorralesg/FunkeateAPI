package com.example.funkeateapi.repository;

import com.example.funkeateapi.model.Venta;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * author = Jacko Tinoco
 *
 * */

public interface VentaRepository extends CrudRepository<Venta, Integer> {
    List<Venta> findById(int id);
}
