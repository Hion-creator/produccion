package com.example.produccion.service;

import com.example.produccion.dto.request.RequestOrdenProduccionDTO;
import com.example.produccion.dto.response.ResponseOrdenProduccionDTO;
import java.util.List;

public interface OrdenProduccionService {
    ResponseOrdenProduccionDTO crearOrden(RequestOrdenProduccionDTO request);
    List<ResponseOrdenProduccionDTO> listarOrdenes();
}

