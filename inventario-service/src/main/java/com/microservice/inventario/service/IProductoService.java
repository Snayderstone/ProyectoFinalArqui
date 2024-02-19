package com.microservice.inventario.service;

import com.microservice.inventario.model.Producto;

public interface IProductoService extends ICRUDService<Producto,Integer> {
    Producto findProductoNombre(String nombreProducto);

}
