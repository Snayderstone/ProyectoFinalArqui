package com.microservice.ventafisica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO {
    private int cantidad;
    private AlmacenDTO almacen;
    private ProductoDTO producto;
}




















