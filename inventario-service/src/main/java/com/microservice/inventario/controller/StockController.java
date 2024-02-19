package com.microservice.inventario.controller;

import com.microservice.inventario.model.Almacen;
import com.microservice.inventario.model.Producto;
import com.microservice.inventario.model.Stock;
import com.microservice.inventario.service.IAlmacenService;
import com.microservice.inventario.service.IProductoService;
import com.microservice.inventario.service.IStockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario/stocks")
@Slf4j
public class StockController {
    @Autowired
    private IStockService service;

    @Autowired
    private IProductoService productoService;

    @Autowired
    private IAlmacenService almacenService;
    @GetMapping
    public ResponseEntity<List<Stock>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(service.findById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Stock obj){
        service.save(obj);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Stock> update(@RequestBody Stock obj){
        Stock response = service.findById(obj.getIdStock());
        if (response == null){
            throw new RuntimeException();
        }
        return new ResponseEntity<>(service.update(obj),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Integer id){
        Stock obj = service.findById(id);
        if (obj == null) {
            throw new RuntimeException();
        } else{
            service.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public Producto findProductoNombre(String nombreProducto){
        if(String.valueOf(nombreProducto) != null){
            Producto producto = productoService.findProductoNombre(nombreProducto);
            if(producto != null){
                return producto;
            }
        }
        return null;
    }

    public Almacen findAlmacenNombre(String nombreAlmacen){
        if(String.valueOf(nombreAlmacen) != null){
            Almacen almacen = almacenService.findAlmacenNombre(nombreAlmacen);
            if(almacen != null){
                return almacen;
            }
        }
        return null;
    }

    @GetMapping("/producto")
    public ResponseEntity<?> findByProductoAlmacen(@RequestParam("producto") String nombreProducto,
                                                  @RequestParam("almacen") String nombreAlmacen){

        Producto producto = findProductoNombre(nombreProducto);
        Almacen almacen = findAlmacenNombre(nombreAlmacen);
        if(producto!=null || almacen!=null){
            Stock stock = service.findByProductoAlmacen(producto,almacen);
            if(stock==null){
                return new ResponseEntity<>(new Stock(), HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(stock, HttpStatus.OK);
        }else
        {
            return new ResponseEntity<>(new Stock(), HttpStatus.NO_CONTENT);
        }
    }
}
























