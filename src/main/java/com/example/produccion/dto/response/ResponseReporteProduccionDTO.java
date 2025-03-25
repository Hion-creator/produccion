package com.example.produccion.dto.response;

import lombok.Data;

@Data
public class ResponseReporteProduccionDTO {
    private String mensaje;
    private byte[] reporte;
}

