package com.example.produccion.service.impl;

import com.example.produccion.dto.request.RequestProcesoProduccionDTO;
import com.example.produccion.dto.response.ResponseProcesoProduccionDTO;
import com.example.produccion.entity.OrdenProduccionEntity;
import com.example.produccion.repository.OrdenProduccionRepository;
import com.example.produccion.service.ProcesoProduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ProcesoProduccionServiceImpl implements ProcesoProduccionService {

    @Autowired
    private OrdenProduccionRepository ordenRepository;

    @Override
    public ResponseProcesoProduccionDTO iniciarProceso(RequestProcesoProduccionDTO request) {
        ResponseProcesoProduccionDTO response = new ResponseProcesoProduccionDTO();
        Timestamp fechaCorte;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fechaCorte = new Timestamp(sdf.parse(request.getFechaCorte()).getTime());
        } catch (ParseException e) {
            response.setMensaje("Fecha inválida");
            response.setOrdenesProcesadas(0);
            return response;
        }
        // Buscar órdenes en estado "Inicial" anteriores a la fecha de corte
        List<OrdenProduccionEntity> ordenes = ordenRepository.findByEstadoAndFechaCreacionBefore("Inicial", fechaCorte);
        int count = ordenes.size();
        // Actualizar el estado de cada orden a "En Proceso"
        for (OrdenProduccionEntity orden : ordenes) {
            orden.setEstado("En Proceso");
            ordenRepository.save(orden);
        }
        response.setMensaje("Proceso iniciado y " + count + " órdenes actualizadas");
        response.setOrdenesProcesadas(count);
        return response;
    }
}

