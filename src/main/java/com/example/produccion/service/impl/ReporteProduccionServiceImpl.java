package com.example.produccion.service.impl;

import com.example.produccion.dto.request.RequestReporteProduccionDTO;
import com.example.produccion.dto.response.ResponseReporteProduccionDTO;
import com.example.produccion.entity.OrdenProduccionEntity;
import com.example.produccion.repository.OrdenProduccionRepository;
import com.example.produccion.service.ReporteProduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ReporteProduccionServiceImpl implements ReporteProduccionService {

    @Autowired
    private OrdenProduccionRepository ordenRepository;

    @Override
    public ResponseReporteProduccionDTO generarReporte(RequestReporteProduccionDTO request) {
        ResponseReporteProduccionDTO response = new ResponseReporteProduccionDTO();
        Timestamp fechaInicio, fechaFin;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            fechaInicio = new Timestamp(sdf.parse(request.getFechaInicio()).getTime());
            fechaFin = new Timestamp(sdf.parse(request.getFechaFin()).getTime());
        } catch (ParseException e) {
            response.setMensaje("Error en las fechas proporcionadas");
            response.setReporte(new byte[0]);
            return response;
        }
        // Para efectos de este ejemplo, consultamos todas las órdenes y simulamos un reporte.
        List<OrdenProduccionEntity> ordenes = ordenRepository.findAll();
        byte[] reporteSimulado = ("Reporte generado del " + request.getFechaInicio() + " al " + request.getFechaFin()).getBytes();
        response.setMensaje("Reporte generado exitosamente");
        response.setReporte(reporteSimulado);
        return response;
    }
}

