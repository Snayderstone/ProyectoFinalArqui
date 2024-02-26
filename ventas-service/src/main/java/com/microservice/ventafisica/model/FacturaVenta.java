package com.microservice.ventafisica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturaVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFacturaVenta;

    @Column(nullable = false)
    private LocalDateTime fechaVenta;

    @Column(name = "descuentoVenta", nullable = false)
    private double descuento;

    @Column(name = "numeroPedido", nullable = false)
    private int numeroPedido;

    @Column(nullable = false)
    private BigDecimal total;

    @Column(nullable = false)
    private Integer idProducto;

    @OneToMany(mappedBy = "facturaVenta", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<DetalleVenta> detalleVentas;

}
