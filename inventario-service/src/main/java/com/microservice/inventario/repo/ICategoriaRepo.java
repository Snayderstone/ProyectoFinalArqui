package com.microservice.inventario.repo;

import com.microservice.inventario.model.Categoria;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepo extends IGenericRepo<Categoria,Integer> {
}
