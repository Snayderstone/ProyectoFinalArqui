package com.example.demo.repository;
import com.example.demo.entity.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductoRepository extends MongoRepository<Producto, Integer> {



}
