package com.example.funkeateapi.repository;

import com.example.funkeateapi.model.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Integer>{
	
}
