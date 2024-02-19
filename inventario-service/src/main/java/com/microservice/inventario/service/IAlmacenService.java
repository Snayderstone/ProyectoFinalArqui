package com.microservice.inventario.service;

import com.microservice.inventario.model.Almacen;
import com.microservice.inventario.model.Producto;

public interface IAlmacenService extends ICRUDService<Almacen,Integer> {
    Almacen findAlmacenNombre(String nombreAlmacen);

}
