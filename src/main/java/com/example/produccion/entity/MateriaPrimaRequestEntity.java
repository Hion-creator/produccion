package com.example.produccion.entity;

import lombok.Data;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "materia_prima_request")
@Data
public class MateriaPrimaRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Timestamp fechaSolicitud;
    
    // Para simplificar, almacenamos los detalles en formato JSON
    @Lob
    private String detalles;
}

