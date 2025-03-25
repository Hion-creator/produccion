package com.example.produccion.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MateriaPrimaDetalleDTO {
    @NotNull(message = "El idMateriaPrima es obligatorio")
    private Long idMateriaPrima;
    
    @NotNull(message = "La cantidad solicitada es obligatoria")
    @Min(value = 1, message = "La cantidad solicitada debe ser mayor que cero")
    private Integer cantidadSolicitada;
}



