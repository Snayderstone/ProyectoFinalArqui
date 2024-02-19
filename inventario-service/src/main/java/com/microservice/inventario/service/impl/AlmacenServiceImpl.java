package com.microservice.inventario.service.impl;

import com.microservice.inventario.model.Almacen;
import com.microservice.inventario.model.Producto;
import com.microservice.inventario.repo.IAlmacenRepo;
import com.microservice.inventario.repo.IGenericRepo;
import com.microservice.inventario.service.IAlmacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlmacenServiceImpl extends CRUDImpl<Almacen,Integer> implements IAlmacenService {
    @Autowired
    private IAlmacenRepo repo;
    @Override
    protected IGenericRepo<Almacen, Integer> getGenericRepo() {
        return repo;
    }
    @Override
    public Almacen findAlmacenNombre(String nombre) {
        return repo.findAlmacenNombre(nombre);
    }
}
