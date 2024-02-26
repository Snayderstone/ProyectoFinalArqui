package com.microservice.ventafisica.service;

import com.microservice.ventafisica.dto.StockDTO;
import com.microservice.ventafisica.model.FacturaVenta;

import java.time.LocalDateTime;
import java.util.List;

public interface IFacturaVentaService extends ICRUDService<FacturaVenta,Integer> {

    StockDTO findByProductoAlmacen(String nombreProducto, String nombreAlmacen);
    List<StockDTO> findAllStock();

    List<FacturaVenta> buscarFacturasPorFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    FacturaVenta buscarFacturaPorNumeroPedido(int numeroPedido);
}