package com.example.produccion.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RequestProcesoProduccionDTO {
    @NotEmpty(message = "La fecha de corte es obligatoria")
    private String fechaCorte;
}


