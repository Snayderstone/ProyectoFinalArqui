package com.example.demo.controller;

import com.example.demo.Service.OrdenCompraService;
import com.example.demo.entity.OrdenCompra;
import com.example.demo.repository.OrdenCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedor/orden_compras")
public class OrdenCompController {

    @Autowired
    private OrdenCompraRepository ordencomprepo;
    @Autowired
    private OrdenCompraService ordenCompraService;


    @PostMapping
    public ResponseEntity<?> SaveOrden(@RequestBody OrdenCompra ordencomp){
        try{
            OrdenCompra provsave = ordencomprepo.save(ordencomp);
            return new ResponseEntity<OrdenCompra>(provsave, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping
    public ResponseEntity<?> findAllOrden(){
        try{
            List<OrdenCompra> provs = ordencomprepo.findAll();
            return new ResponseEntity<List<OrdenCompra>>(provs, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<?> updateOrden(@RequestBody OrdenCompra ordencomp){
        try{
            OrdenCompra provsave = ordencomprepo.save(ordencomp);
            return new ResponseEntity<OrdenCompra>(provsave, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteOrden(@PathVariable Integer id){
        try{
            ordencomprepo.deleteById(id);
            return new ResponseEntity<String>("Eliminado", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/total/{id}")
    public ResponseEntity<Double> getTotalFactura(@PathVariable Integer id) {
        double totalFactura = ordenCompraService.calcularTotalFactura(id);
        return new ResponseEntity<>(totalFactura, HttpStatus.OK);
    }

}
