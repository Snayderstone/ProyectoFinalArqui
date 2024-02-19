package com.example.demo.controller;

import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepo;

    @PostMapping
    public ResponseEntity<?> SaveProducto(@RequestBody Producto producto){
        try{
            Producto ProSave = productoRepo.save(producto);
            return new ResponseEntity<Producto>(ProSave, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping
    public ResponseEntity<?> findAllProducto(){
        try{
            List<Producto> provs = productoRepo.findAll();
            return new ResponseEntity<List<Producto>>(provs, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateProducto(@RequestBody Producto producto){
        try{
            Producto provsave = productoRepo.save(producto);
            return new ResponseEntity<Producto>(provsave, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable Integer id){
        try{
            productoRepo.deleteById(id);
            return new ResponseEntity<String>("Eliminado", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
