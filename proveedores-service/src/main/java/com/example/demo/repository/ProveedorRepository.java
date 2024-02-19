package com.example.demo.repository;
import com.example.demo.entity.Proveedor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProveedorRepository extends MongoRepository <Proveedor, Integer> {

}
