package com.example.produccion.service.impl;

import com.example.produccion.dto.request.RequestMateriaPrimaDTO;
import com.example.produccion.dto.response.ResponseMateriaPrimaDTO;
import com.example.produccion.entity.MateriaPrimaRequestEntity;
import com.example.produccion.repository.MateriaPrimaRequestRepository;
import com.example.produccion.service.MateriaPrimaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;

@Service
public class MateriaPrimaServiceImpl implements MateriaPrimaService {

    @Autowired
    private MateriaPrimaRequestRepository materiaPrimaRepository;

    @Override
    public ResponseMateriaPrimaDTO solicitarMateriaPrima(RequestMateriaPrimaDTO request) {
        ResponseMateriaPrimaDTO response = new ResponseMateriaPrimaDTO();
        try {
            ObjectMapper mapper = new ObjectMapper();
            String detallesJson = mapper.writeValueAsString(request.getDetalles());
            
            MateriaPrimaRequestEntity entity = new MateriaPrimaRequestEntity();
            entity.setFechaSolicitud(new Timestamp(System.currentTimeMillis()));
            entity.setDetalles(detallesJson);
            materiaPrimaRepository.save(entity);
            response.setMensaje("Solicitud de materia prima realizada correctamente");
        } catch(Exception e) {
            response.setMensaje("Error al procesar la solicitud de materia prima");
        }
        return response;
    }
}

