package com.example.demo.repository;

import com.example.demo.entity.OrdenCompra;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface OrdenCompraRepository extends MongoRepository<OrdenCompra, Integer> {

}
