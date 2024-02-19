package com.example.demo.repository;

import com.example.demo.entity.DetalleCompra;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DetalleCompraRepository extends MongoRepository<DetalleCompra, Integer> {

}
