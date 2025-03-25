package com.example.produccion.service;

import com.example.produccion.dto.request.RequestInspeccionProductoDTO;
import com.example.produccion.dto.response.ResponseInspeccionProductoDTO;

public interface InspeccionProductoService {
    ResponseInspeccionProductoDTO inspeccionarProducto(RequestInspeccionProductoDTO request);
}

