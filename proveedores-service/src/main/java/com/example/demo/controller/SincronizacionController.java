//package com.example.demo.controller;
//
//import com.example.demo.Service.SincronizacionService;
//import com.example.demo.entity.Sincronizacion;
//import com.example.demo.repository.SincronizacionRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/Sincroniz")
//public class SincronizacionController {
//
//    @Autowired
//    private SincronizacionRepository sincronizrepo;
//
//    @Autowired
//    private SincronizacionService sincronizacionService;
//
//    @PostMapping
//    public ResponseEntity<?> SaveSincroniz(@RequestBody Sincronizacion sincrozs){
//        try{
//            Sincronizacion provsave = sincronizrepo.save(sincrozs);
//            return new ResponseEntity<Sincronizacion>(provsave, HttpStatus.CREATED);
//        }catch (Exception e){
//            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//
//    @GetMapping
//    public ResponseEntity<?> findAllSincroniz(){
//        try{
//            List<Sincronizacion> provs = sincronizrepo.findAll();
//            return new ResponseEntity<List<Sincronizacion>>(provs, HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PutMapping
//    public ResponseEntity<?> updateSincroniz(@RequestBody Sincronizacion sincrozs){
//        try{
//            Sincronizacion provsave = sincronizrepo.save(sincrozs);
//            return new ResponseEntity<Sincronizacion>(provsave, HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<?> deleteSincroniz(@PathVariable Integer id){
//        try{
//            sincronizrepo.deleteById(id);
//            return new ResponseEntity<String>("Eliminado", HttpStatus.OK);
//        }catch (Exception e){
//            return new ResponseEntity<String>(e.getCause().toString(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @GetMapping("/status/{estado}")
//    public ResponseEntity<Sincronizacion> buscarPorEstado(@PathVariable String estado) {
//        Sincronizacion sincronizacion = sincronizacionService.buscarPorEstado(estado);
//        if (sincronizacion != null) {
//            return new ResponseEntity<>(sincronizacion, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//
//}
