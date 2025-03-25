package com.example.produccion.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RequestReporteProduccionDTO {
    @NotEmpty(message = "La fecha de inicio es obligatoria")
    private String fechaInicio;
    
    @NotEmpty(message = "La fecha de fin es obligatoria")
    private String fechaFin;
    
    @NotEmpty(message = "El formato es obligatorio (PDF o Excel)")
    private String formato;
}


