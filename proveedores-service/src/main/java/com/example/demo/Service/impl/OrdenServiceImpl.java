package com.example.demo.Service.impl;

import com.example.demo.entity.OrdenCompra;
import com.example.demo.entity.DetalleCompra;
import com.example.demo.repository.OrdenCompraRepository;
import com.example.demo.Service.OrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenServiceImpl implements OrdenCompraService {

    @Autowired
    private OrdenCompraRepository ordenCompraRepository;

    @Override
    public List<OrdenCompra> listAllOrden() {
        return ordenCompraRepository.findAll();
    }

    @Override
    public OrdenCompra getOrden(Integer id) {
        return ordenCompraRepository.findById(id).orElse(null);
    }

    @Override
    public OrdenCompra createOrden(OrdenCompra ordenCompra) {
        ordenCompra.setStatus("CREATED");
        return ordenCompraRepository.save(ordenCompra);
    }

    @Override
    public OrdenCompra updateOrden(OrdenCompra ordenCompra) {
        OrdenCompra ordenCompraDB = getOrden(ordenCompra.getId());
        if(null == ordenCompraDB){
            return null;
        }
        ordenCompraDB.setEstadoOrden(ordenCompra.getEstadoOrden());
        ordenCompraDB.setFechaOrden(ordenCompra.getFechaOrden());
        ordenCompraDB.setTotalOrden(ordenCompra.getTotalOrden());
        return ordenCompraRepository.save(ordenCompraDB);
    }

    @Override
    public OrdenCompra deleteOrden(Integer id) {
        OrdenCompra ordenCompraDB = getOrden(id);
        if (null == ordenCompraDB){
            return null;
        }
        ordenCompraDB.setStatus("DELETED");
        return ordenCompraRepository.save(ordenCompraDB);
    }

    @Override
    public double calcularTotalFactura(Integer id) {
        OrdenCompra ordenCompra = ordenCompraRepository.findById(id).orElse(null);
        if (ordenCompra == null) {
            return 0.0; // Manejar la situación de orden de compra no encontrada
        }
        return calcularTotalFactura(ordenCompra);
    }

    private double calcularTotalFactura(OrdenCompra ordenCompra) {
        double totalFactura = 0.0;
        List<DetalleCompra> detallesCompra = ordenCompra.getDetallesCompra();
        if (detallesCompra != null) {
            for (DetalleCompra detalleCompra : detallesCompra) {
                totalFactura += detalleCompra.getCantidadComprada() * detalleCompra.getPrecioUnitario();
            }
        }
        return totalFactura;
    }

}
