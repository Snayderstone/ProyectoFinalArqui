package com.microservice.ventafisica.service;

import com.microservice.ventafisica.model.FacturaVenta;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ICRUDService<T,ID>{
    T save(T t);
    T update(T t);
    T findById(ID id);

    List<FacturaVenta> buscarVentasPorFecha(Date fechaInicio, Date fechaFin);

    List<FacturaVenta> buscarVentasPorFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    FacturaVenta buscarVentaPorNumeroPedido(int numeroPedido);

    List<T> findAll();
    void delete(ID id);

    FacturaVenta calcularTotales(FacturaVenta facturaventa);
}