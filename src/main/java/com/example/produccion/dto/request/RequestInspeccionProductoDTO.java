package com.example.produccion.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RequestInspeccionProductoDTO {
    @NotNull(message = "El idProducto es obligatorio")
    private Long idProducto;
    
    @NotNull(message = "El idOrdenProduccion es obligatorio")
    private Long idOrdenProduccion;
    
    @NotNull(message = "La cantidad inspeccionada es obligatoria")
    @Min(value = 1, message = "La cantidad inspeccionada debe ser mayor que cero")
    private Integer cantidadInspeccionada;
    
    @NotNull(message = "La muestra requerida es obligatoria")
    @Min(value = 1, message = "La muestra requerida debe ser mayor que cero")
    private Integer muestraRequerida;
}


