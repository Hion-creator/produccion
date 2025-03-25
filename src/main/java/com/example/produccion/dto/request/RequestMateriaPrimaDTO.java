package com.example.produccion.dto.request;

import lombok.Data;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;

@Data
public class RequestMateriaPrimaDTO {
    @NotEmpty(message = "La lista de detalles no puede estar vacía")
    private List<MateriaPrimaDetalleDTO> detalles;
}


