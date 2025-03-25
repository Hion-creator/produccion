package com.example.produccion.service;

import com.example.produccion.dto.request.RequestProcesoProduccionDTO;
import com.example.produccion.dto.response.ResponseProcesoProduccionDTO;

public interface ProcesoProduccionService {
    ResponseProcesoProduccionDTO iniciarProceso(RequestProcesoProduccionDTO request);
}

