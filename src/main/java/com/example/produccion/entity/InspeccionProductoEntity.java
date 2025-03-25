package com.example.produccion.entity;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "inspeccion_producto")
@Data
public class InspeccionProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long idProducto;
    private Long idOrdenProduccion;
    private Integer cantidadInspeccionada;
    private Integer muestraRequerida;
    private String resultado; // "APROBADO" o "RECHAZADO"
    private String observaciones;
    private Timestamp fechaInspeccion;
}

