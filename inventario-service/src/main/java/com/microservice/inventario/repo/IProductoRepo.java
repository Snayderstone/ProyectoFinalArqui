package com.microservice.inventario.repo;

import com.microservice.inventario.model.Producto;
import com.microservice.inventario.model.Stock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepo extends IGenericRepo<Producto, Integer> {
    @Query("SELECT p FROM Producto p WHERE p.nombre = :nombreProducto")
    Producto findByProductoNombre(String nombreProducto);
}
