package com.example.produccion.service.impl;

import com.example.produccion.dto.request.RequestOrdenProduccionDTO;
import com.example.produccion.dto.response.ResponseOrdenProduccionDTO;
import com.example.produccion.entity.OrdenProduccionEntity;
import com.example.produccion.repository.OrdenProduccionRepository;
import com.example.produccion.service.OrdenProduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdenProduccionServiceImpl implements OrdenProduccionService {

    @Autowired
    private OrdenProduccionRepository ordenRepository;
    
    @Override
    public ResponseOrdenProduccionDTO crearOrden(RequestOrdenProduccionDTO request) {
        OrdenProduccionEntity orden = new OrdenProduccionEntity();
        orden.setIdProducto(request.getIdProducto());
        orden.setDescripcion(request.getDescripcion());
        orden.setObservacion(request.getObservacion());
        orden.setCantidad(request.getCantidad());
        orden.setFechaCreacion(new Timestamp(System.currentTimeMillis()));
        orden.setEstado("Inicial");
        OrdenProduccionEntity saved = ordenRepository.save(orden);
        ResponseOrdenProduccionDTO response = new ResponseOrdenProduccionDTO();
        response.setIdOrden(saved.getId());
        response.setMensaje("Orden creada exitosamente");
        response.setFechaCreacion(saved.getFechaCreacion());
        return response;
    }

    @Override
    public List<ResponseOrdenProduccionDTO> listarOrdenes() {
        List<OrdenProduccionEntity> ordenes = ordenRepository.findAll();
        return ordenes.stream().map(o -> {
            ResponseOrdenProduccionDTO dto = new ResponseOrdenProduccionDTO();
            dto.setIdOrden(o.getId());
            dto.setMensaje(o.getDescripcion());
            dto.setFechaCreacion(o.getFechaCreacion());
            return dto;
        }).collect(Collectors.toList());
    }
}

