package com.example.demo.repository;

import com.example.demo.entity.Sincronizacion;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface SincronizacionRepository extends MongoRepository<Sincronizacion, Integer> {
    Sincronizacion findByEstado(String estado);


}
