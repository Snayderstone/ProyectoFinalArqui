package com.microservice.inventario.repo;

import com.microservice.inventario.model.Almacen;
import com.microservice.inventario.model.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IAlmacenRepo extends IGenericRepo<Almacen, Integer> {
    @Query("SELECT a FROM Almacen a WHERE a.nombre = :nombreAlmacen")
    Almacen findAlmacenNombre(String nombreAlmacen);
}
