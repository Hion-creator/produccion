package com.example.produccion.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class RequestOrdenProduccionDTO {
    @NotNull(message = "El idProducto es obligatorio")
    private Long idProducto;
    
    @NotEmpty(message = "La descripción es obligatoria")
    private String descripcion;
    
    private String observacion;
    
    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad debe ser mayor que cero")
    private Integer cantidad;
}


