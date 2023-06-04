package com.example.funkeateapi.repository;

import com.example.funkeateapi.model.Categoria;
import com.example.funkeateapi.model.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {
    List<Producto> findByCategoria(Categoria cat);
}

