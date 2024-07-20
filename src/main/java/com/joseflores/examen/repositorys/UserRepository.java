package com.joseflores.examen.repositorys;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.joseflores.examen.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
    User findByEmail(String email);
    List<User> findAll();

}
