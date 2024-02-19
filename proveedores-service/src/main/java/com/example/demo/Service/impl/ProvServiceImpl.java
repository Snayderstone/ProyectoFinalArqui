package com.example.demo.Service.impl;

import com.example.demo.entity.Proveedor;
import com.example.demo.repository.ProveedorRepository;
import com.example.demo.Service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProvServiceImpl implements ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> listAllProveedor() {
        return proveedorRepository.findAll();
    }

    @Override
    public Proveedor getProveedor(Integer id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    @Override
    public Proveedor createProveedor(Proveedor proveedor) {
        proveedor.setStatus("CREATED");
        return proveedorRepository.save(proveedor);
    }

    @Override
    public Proveedor updateProveedor(Proveedor proveedor) {
        Proveedor provedDB = getProveedor(proveedor.getId());
        if (null == provedDB){
            return null;
        }

        provedDB.setNombre(proveedor.getNombre());
        provedDB.setApellido(proveedor.getApellido());
        provedDB.setTelf(proveedor.getTelf());
        provedDB.setCorreo(proveedor.getCorreo());
        provedDB.setDireccion(proveedor.getDireccion());
        return proveedorRepository.save(provedDB);
    }

    @Override
    public Proveedor deleteProveedor(Integer id) {
        Proveedor provedDB = getProveedor(id);
        if (null == provedDB){
            return null;
        }
        provedDB.setStatus("DELETED");
        return proveedorRepository.save(provedDB);
    }

}
