package com.example.produccion.service.impl;

import com.example.produccion.dto.request.RequestInspeccionProductoDTO;
import com.example.produccion.dto.response.ResponseInspeccionProductoDTO;
import com.example.produccion.entity.InspeccionProductoEntity;
import com.example.produccion.repository.InspeccionProductoRepository;
import com.example.produccion.service.InspeccionProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;

@Service
public class InspeccionProductoServiceImpl implements InspeccionProductoService {

    @Autowired
    private InspeccionProductoRepository inspeccionRepository;

    @Override
    public ResponseInspeccionProductoDTO inspeccionarProducto(RequestInspeccionProductoDTO request) {
        ResponseInspeccionProductoDTO response = new ResponseInspeccionProductoDTO();
        String resultado;
        if(request.getCantidadInspeccionada() >= request.getMuestraRequerida()){
            resultado = "APROBADO";
            response.setObservaciones("Producto cumple con los estándares de calidad.");
        } else {
            resultado = "RECHAZADO";
            response.setObservaciones("Producto no cumple con la cantidad requerida.");
        }
        // Registrar la inspección en la BD
        InspeccionProductoEntity inspeccion = new InspeccionProductoEntity();
        inspeccion.setIdProducto(request.getIdProducto());
        inspeccion.setIdOrdenProduccion(request.getIdOrdenProduccion());
        inspeccion.setCantidadInspeccionada(request.getCantidadInspeccionada());
        inspeccion.setMuestraRequerida(request.getMuestraRequerida());
        inspeccion.setResultado(resultado);
        inspeccion.setFechaInspeccion(new Timestamp(System.currentTimeMillis()));
        inspeccionRepository.save(inspeccion);
        
        response.setResultado(resultado);
        return response;
    }
}

