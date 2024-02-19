package com.microservice.ventafisica.api;

import com.microservice.ventafisica.dto.StockDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="inventario-service")
@Component
public interface InventarioClient {

    @GetMapping("/stocks")
    List<StockDTO> findAllStock();
    @GetMapping("/api/stocks/productos")
    StockDTO findByProductoAlmacen(@RequestParam("productos") String nombreProducto,
                                   @RequestParam("almacenes") String nombreAlmacen);
}
