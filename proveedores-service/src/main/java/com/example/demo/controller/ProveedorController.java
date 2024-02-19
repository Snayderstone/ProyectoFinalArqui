package com.example.demo.controller;

import com.example.demo.entity.Proveedor;
import com.example.demo.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorRepository proveedorRepo;

    @PostMapping
    public ResponseEntity<?> SaveProveedor(@RequestBody Proveedor proveedor){
        try{
            Proveedor provsave = proveedorRepo.save(proveedor);
            return new ResponseEntity<Proveedor>(provsave, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping
    public ResponseEntity<?> findAllProveedores(){
        try{
            List<Proveedor> provs = proveedorRepo.findAll();
            return new ResponseEntity<List<Proveedor>>(provs, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateProveedor(@RequestBody Proveedor proveedor){
        try{
            Proveedor provsave = proveedorRepo.save(proveedor);
            return new ResponseEntity<Proveedor>(provsave, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteProveedor(@PathVariable Integer id){
        try{
            proveedorRepo.deleteById(id);
            return new ResponseEntity<String>("Eliminado", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

