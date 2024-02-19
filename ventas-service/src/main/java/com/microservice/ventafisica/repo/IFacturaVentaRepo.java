package com.microservice.ventafisica.repo;

import com.microservice.ventafisica.model.FacturaVenta;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacturaVentaRepo<T,ID> extends IGenericRepo<FacturaVenta,Integer> {

}
