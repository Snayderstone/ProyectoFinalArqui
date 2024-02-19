package com.example.demo.Service.impl;

import com.example.demo.entity.DetalleCompra;
import com.example.demo.entity.Producto;
import com.example.demo.repository.DetalleCompraRepository;
import com.example.demo.Service.DetalleCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleServiceImpl implements DetalleCompraService {

    @Autowired
    private DetalleCompraRepository detalleCompraRepository;


    @Override
    public List<DetalleCompra> listAllDetalle() {
        return detalleCompraRepository.findAll();
    }

    @Override
    public DetalleCompra getDetalle(Integer id) {
        return detalleCompraRepository.findById(id).orElse(null);
    }

    @Override
    public DetalleCompra createDetalle(DetalleCompra detalleCompra) {
        detalleCompra.setStatus("CREATED");
        return detalleCompraRepository.save(detalleCompra);
    }

    @Override
    public DetalleCompra updateDetalle(DetalleCompra detalleCompra) {
        DetalleCompra detalleCompraDB = getDetalle(detalleCompra.getId());
        if (null == detalleCompraDB){
            return null;
        }
        detalleCompraDB.setCorreoCliente(detalleCompra.getCorreoCliente());
        detalleCompraDB.setCantidadComprada(detalleCompra.getCantidadComprada());
        detalleCompraDB.setPrecioUnitario(detalleCompra.getPrecioUnitario());

        return detalleCompraRepository.save(detalleCompra);
    }

    @Override
    public DetalleCompra deleteDetalle(Integer id) {
        DetalleCompra detalleCompDB = getDetalle(id);
        if (null == detalleCompDB){
            return null;
        }
        detalleCompDB.setStatus("DELETED");
        return detalleCompraRepository.save(detalleCompDB);
    }

    @Override
    public List<Producto> FindByIdProducto(Integer id) {
        return null;
    }
}
