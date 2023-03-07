package com.controlblack.controlblackback.CRUD.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.controlblack.controlblackback.CRUD.entity.Viaje;

@Repository
public interface ViajeRepository extends MongoRepository<Viaje, Integer>{
    boolean existsByBeetrack(String beetrack);
    Optional<Viaje> findByBeetrack(String beetrack);
}
