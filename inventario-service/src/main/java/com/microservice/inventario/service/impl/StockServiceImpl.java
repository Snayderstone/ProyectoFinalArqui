package com.microservice.inventario.service.impl;

import com.microservice.inventario.model.Almacen;
import com.microservice.inventario.model.Producto;
import com.microservice.inventario.model.Stock;
import com.microservice.inventario.repo.IGenericRepo;
import com.microservice.inventario.repo.IStockRepo;
import com.microservice.inventario.service.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl extends CRUDImpl<Stock,Integer> implements IStockService {
    @Autowired
    private IStockRepo repo;
    @Override
    protected IGenericRepo<Stock, Integer> getGenericRepo() {
        return repo;
    }

    @Override
    public Stock findByProductoAlmacen(Producto producto, Almacen almacen)
    {
        return repo.findByProductoAlmacen(producto, almacen);
    }
}
