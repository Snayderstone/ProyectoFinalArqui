package com.microservice.inventario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStock;
    @Column(nullable = false)
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "id_almacen", nullable = false, foreignKey = @ForeignKey(name = "FK_STOCK_ALMACEN"))
    private Almacen almacen;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false, foreignKey = @ForeignKey(name = "FK_STOCK_PRODUCTO"))
    private Producto producto;
}




















