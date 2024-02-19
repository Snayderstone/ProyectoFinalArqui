package com.example.demo.controller;

import com.example.demo.Service.DetalleCompraService;
import com.example.demo.entity.DetalleCompra;
import com.example.demo.repository.DetalleCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle_compras")
public class DetalleCompController {

    @Autowired
    private DetalleCompraRepository detallrepo;

    private DetalleCompraService detallserv;

    @PostMapping
    public ResponseEntity<?> SaveDetalle(@RequestBody DetalleCompra detall){
        try{
            DetalleCompra provsave = detallrepo.save(detall);
            return new ResponseEntity<DetalleCompra>(provsave, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping
    public ResponseEntity<?> findAllDetalle(){
        try{
            List<DetalleCompra> provs = detallrepo.findAll();
            return new ResponseEntity<List<DetalleCompra>>(provs, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateDetalle(@RequestBody DetalleCompra detall){
        try{
            DetalleCompra provsave = detallrepo.save(detall);
            return new ResponseEntity<DetalleCompra>(provsave, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteDetalle(@PathVariable Integer id){
        try{
            detallrepo.deleteById(id);
            return new ResponseEntity<String>("Eliminado", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/search-ny-product/{id}")
    public ResponseEntity <?> FindByIdProducto(@PathVariable Integer id){
        return ResponseEntity.ok(detallserv.FindByIdProducto(id));

    }



}
