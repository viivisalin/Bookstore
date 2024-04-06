package com.example.Bookstore.model;

import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository extends CrudRepository<Category, Long>{
  Category findByName(String name);

}
