package com.example.produccion.dto.response;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class ResponseOrdenProduccionDTO {
    private Long idOrden;
    private String mensaje;
    private Timestamp fechaCreacion;
}


