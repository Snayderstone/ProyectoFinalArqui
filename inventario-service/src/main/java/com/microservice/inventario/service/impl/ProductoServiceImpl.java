package com.microservice.inventario.service.impl;

import com.microservice.inventario.model.Producto;
import com.microservice.inventario.repo.IGenericRepo;
import com.microservice.inventario.repo.IProductoRepo;
import com.microservice.inventario.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends CRUDImpl<Producto,Integer> implements IProductoService {
    @Autowired
    private IProductoRepo repo;
    @Override
    protected IGenericRepo<Producto, Integer> getGenericRepo() {
        return repo;
    }

    @Override
    public Producto findProductoNombre(String nombre) {
        return repo.findByProductoNombre(nombre);
    }
}
