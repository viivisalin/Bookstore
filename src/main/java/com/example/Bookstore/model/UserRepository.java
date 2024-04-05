package com.example.Bookstore.model;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String>{
    User findByUsername(String username);
}
