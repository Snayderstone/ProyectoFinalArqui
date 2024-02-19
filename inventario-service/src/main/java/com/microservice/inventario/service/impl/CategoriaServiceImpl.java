package com.microservice.inventario.service.impl;

import com.microservice.inventario.model.Categoria;
import com.microservice.inventario.repo.ICategoriaRepo;
import com.microservice.inventario.repo.IGenericRepo;
import com.microservice.inventario.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl extends CRUDImpl<Categoria,Integer> implements ICategoriaService {

    @Autowired
    private ICategoriaRepo repo;
    @Override
    protected IGenericRepo<Categoria, Integer> getGenericRepo() {
        return repo;
    }
}
