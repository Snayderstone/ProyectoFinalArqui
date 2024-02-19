
package com.microservice.inventario.service;

import com.microservice.inventario.model.Almacen;
import com.microservice.inventario.model.Producto;
import com.microservice.inventario.model.Stock;

public interface IStockService extends ICRUDService<Stock,Integer> {
    Stock findByProductoAlmacen(Producto producto, Almacen almacen);
}
