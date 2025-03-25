package com.example.produccion.entity;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "orden_produccion")
@Data
public class OrdenProduccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long idProducto;
    private String descripcion;
    private String observacion;
    private Integer cantidad;
    private Timestamp fechaCreacion;
    private String estado; // Ejemplo: "Inicial", "En Proceso", "Completada"
}

