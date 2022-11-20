package com.crudproductos.crudmongodbback.CRUD.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.crudproductos.crudmongodbback.CRUD.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, Integer>{
    boolean existsByNombre(String nombre);
    Optional<Product> findByNombre(String nombre);
}
