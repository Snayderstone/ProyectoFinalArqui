package com.microservice.ventafisica.controller;

import com.microservice.ventafisica.dto.StockDTO;
import com.microservice.ventafisica.model.FacturaVenta;
import com.microservice.ventafisica.service.IFacturaVentaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/ventas")
@Slf4j
public class VentaController {

    @Autowired
    private IFacturaVentaService facturaVentaService;


    @GetMapping
    public ResponseEntity<List<FacturaVenta>> findAll() {
        return new ResponseEntity<>(facturaVentaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaVenta> findById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(facturaVentaService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/buscar-por-fecha")
    public ResponseEntity<List<FacturaVenta>> buscarFacturasPorFecha(
            @RequestParam("fechaInicio") LocalDateTime fechaInicio,
            @RequestParam("fechaFin") LocalDateTime fechaFin) {
        List<FacturaVenta> facturasVenta = facturaVentaService.buscarFacturasPorFecha(fechaInicio, fechaFin);
        return new ResponseEntity<>(facturasVenta, HttpStatus.OK);
    }

    @GetMapping("/buscar-por-numero-pedido")
    public ResponseEntity<FacturaVenta> buscarFacturaPorNumeroPedido(@RequestParam("numeroPedido") int numeroPedido) {
        FacturaVenta facturaVenta = facturaVentaService.buscarFacturaPorNumeroPedido(numeroPedido);
        return new ResponseEntity<>(facturaVenta, HttpStatus.OK);
    }

    @PostMapping("/calcular-totales")
    public ResponseEntity<FacturaVenta> calcularTotales(@RequestBody FacturaVenta facturaVenta) {
        FacturaVenta facturaConTotales = facturaVentaService.calcularTotales(facturaVenta);
        return ResponseEntity.ok(facturaConTotales);
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody FacturaVenta obj) {
        facturaVentaService.save(obj);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<FacturaVenta> update(@RequestBody FacturaVenta obj) {
        FacturaVenta response = facturaVentaService.findById(obj.getIdFacturaVenta());
        if (response == null) {
            throw new RuntimeException();
        }
        return new ResponseEntity<>(facturaVentaService.update(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        FacturaVenta obj = facturaVentaService.findById(id);
        if (obj == null) {
            throw new RuntimeException();
        } else {
            facturaVentaService.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/stock")
    public ResponseEntity<?> findStockByProductoAlmacen(@RequestParam("producto") String nombreProducto, @RequestParam("almacen") String nombreAlmacen) {
        StockDTO stockDTO = facturaVentaService.findByProductoAlmacen(nombreProducto, nombreAlmacen);
        if (stockDTO == null) {
            return ResponseEntity.badRequest().body("El stock es nulo, ingrese datos verdaderos");
        } else {
            if (stockDTO.getCantidad() <= 0) {
                return ResponseEntity.badRequest().body("No existen unidades");
            }
            return new ResponseEntity<>(stockDTO, HttpStatus.OK);
        }
    }

    @GetMapping("/stock/all")
    public ResponseEntity<List<?>> findAllStock() {
        return new ResponseEntity<>(facturaVentaService.findAllStock(), HttpStatus.OK);
    }
}