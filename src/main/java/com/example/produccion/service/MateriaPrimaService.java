package com.example.produccion.service;

import com.example.produccion.dto.request.RequestMateriaPrimaDTO;
import com.example.produccion.dto.response.ResponseMateriaPrimaDTO;

public interface MateriaPrimaService {
    ResponseMateriaPrimaDTO solicitarMateriaPrima(RequestMateriaPrimaDTO request);
}

