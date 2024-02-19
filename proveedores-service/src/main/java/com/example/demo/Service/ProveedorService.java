package com.example.demo.Service;

import com.example.demo.entity.Proveedor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProveedorService {

    public List<Proveedor> listAllProveedor();

    public Proveedor getProveedor(Integer id);

    public Proveedor createProveedor(Proveedor proveedor);

    public Proveedor updateProveedor(Proveedor proveedor);

    public Proveedor deleteProveedor(Integer id);

}
