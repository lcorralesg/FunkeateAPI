package com.example.funkeateapi.repository;

import com.example.funkeateapi.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 *
 * author = Jacko Tinoco
 *
 * */
public interface UsersRepository extends CrudRepository<Users, Integer>{
    Optional<Users> findById(Integer integer);

    Optional<Users> findByEmail(String email);

}
