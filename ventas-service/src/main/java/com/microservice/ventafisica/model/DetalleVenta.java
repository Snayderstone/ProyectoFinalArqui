package com.microservice.ventafisica.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DetalleVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleVenta;

    @ManyToOne
    @JoinColumn(name = "id_facturaVenta",nullable = false,foreignKey = @ForeignKey(name = "FK_DETALLE_FACTURA"))
    private FacturaVenta facturaVenta;

    @Column(nullable = false, length = 4)
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private int cantidad;

    @Column(name = "ivaVenta", nullable = false)
    private double ivaVenta;

    @Column(name = "precio", nullable = false)
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private double precio;

    @Column(name = "correoCliente", nullable = false, length = 50)
    private String correoCliente;

    @Column(nullable = false, length = 5)
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private BigDecimal subTotal;
}
