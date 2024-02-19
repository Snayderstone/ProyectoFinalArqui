package com.microservice.ventafisica.controller;

import com.microservice.ventafisica.dto.StockDTO;
import com.microservice.ventafisica.model.FacturaVenta;
import com.microservice.ventafisica.service.IFacturaVentaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venta")
@Slf4j
public class VentaController {
    @Autowired
    private IFacturaVentaService service;

    @GetMapping
    public ResponseEntity<List<FacturaVenta>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaVenta> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(service.findById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody FacturaVenta obj){
        service.save(obj);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<FacturaVenta> update(@RequestBody FacturaVenta obj){
        FacturaVenta response = service.findById(obj.getIdFacturaVenta());
        if (response == null){
            throw new RuntimeException();
        }
        return new ResponseEntity<>(service.update(obj),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Integer id){
        FacturaVenta obj = service.findById(id);
        if (obj == null) {
            throw new RuntimeException();
        } else{
            service.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/stock")
    public ResponseEntity<?> findStockByProductoAlmacen(@RequestParam("producto") String nombreProducto,
                                                        @RequestParam("almacen") String nombreAlmacen){
        StockDTO stockDTO = service.findByProductoAlmacen(nombreProducto,nombreAlmacen);
        if(stockDTO==null){
            return ResponseEntity.badRequest().body("El stock es nulo, ingrese datos verdaderos");
        }else{
            if(stockDTO.getCantidad()<=0){
                return ResponseEntity.badRequest().body("No existen unidades");
            }
            return new ResponseEntity<>(stockDTO, HttpStatus.OK);
        }
    }

    @GetMapping("/stock/all")
    public ResponseEntity<List<?>> findAllStock(){
        return new ResponseEntity<>(service.findAllStock(), HttpStatus.OK);
    }

}
























