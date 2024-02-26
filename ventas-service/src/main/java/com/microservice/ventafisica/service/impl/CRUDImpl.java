package com.microservice.ventafisica.service.impl;

import com.microservice.ventafisica.model.DetalleVenta;
import com.microservice.ventafisica.model.FacturaVenta;
import com.microservice.ventafisica.repo.IGenericRepo;
import com.microservice.ventafisica.service.ICRUDService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUDService<T, ID> {

    private static final double DESCUENTO_PORCENTAJE = 0.0;

    protected abstract IGenericRepo<T, ID> getGenericRepo();

    @Override
    public T save(T entity) {
        return getGenericRepo().save(entity);
    }

    @Override
    public T update(T entity) {
        return getGenericRepo().save(entity);
    }

    @Override
    public T findById(ID id) {
        return getGenericRepo().findById(id).orElse(null);
    }

    @Override
    public List<FacturaVenta> buscarVentasPorFecha(LocalDateTime fechaInicio, LocalDateTime fechaFin) {

        return null;
    }

    @Override
    public FacturaVenta buscarVentaPorNumeroPedido(int numeroPedido) {

        return null;
    }

    @Override
    public List<T> findAll() {
        return getGenericRepo().findAll();
    }

    @Override
    public void delete(ID id) {
        getGenericRepo().deleteById(id);
    }

    @Override
    public FacturaVenta calcularTotales(FacturaVenta facturaVenta) {
        double total = 0.0;
        List<DetalleVenta> detallesVenta = facturaVenta.getDetalleVentas();


        for (DetalleVenta detalle : detallesVenta) {
            total += detalle.getSubTotal().doubleValue();
        }


        double descuento = calcularDescuento(total);
        facturaVenta.setDescuento(descuento);


        double totalFinal = total - descuento;
        facturaVenta.setTotal(new BigDecimal(totalFinal));

        return facturaVenta;
    }
    private double calcularDescuento(double total) {
        return total * DESCUENTO_PORCENTAJE;
    }
}