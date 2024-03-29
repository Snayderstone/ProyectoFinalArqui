package com.microservice.inventario.service.impl;

import com.microservice.inventario.repo.IGenericRepo;
import com.microservice.inventario.service.ICRUDService;

import java.util.List;

public abstract class CRUDImpl <T,ID> implements ICRUDService<T,ID> {

    protected abstract IGenericRepo<T,ID> getGenericRepo();

    @Override
    public T save(T t) {
        return getGenericRepo().save(t);
    }

    @Override
    public T update(T t) {
        return getGenericRepo().save(t);
    }

    @Override
    public T findById(ID id) {
        return getGenericRepo().findById(id).orElse(null);
    }

    @Override
    public List<T> findAll() {
        return getGenericRepo().findAll();
    }

    @Override
    public void delete(ID id) {
        getGenericRepo().deleteById(id);
    }
}
