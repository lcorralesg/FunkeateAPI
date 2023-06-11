package com.example.funkeateapi.repository;

import com.example.funkeateapi.model.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 *
 * author = Jacko Tinoco
 *
 * */
public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {
    List<Categoria> findByNombre(String categoria_name);
}
