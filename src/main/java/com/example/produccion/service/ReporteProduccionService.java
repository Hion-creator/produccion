package com.example.produccion.service;

import com.example.produccion.dto.request.RequestReporteProduccionDTO;
import com.example.produccion.dto.response.ResponseReporteProduccionDTO;

public interface ReporteProduccionService {
    ResponseReporteProduccionDTO generarReporte(RequestReporteProduccionDTO request);
}

