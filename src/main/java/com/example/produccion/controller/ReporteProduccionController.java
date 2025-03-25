package com.example.produccion.controller;

import com.example.produccion.dto.request.RequestReporteProduccionDTO;
import com.example.produccion.dto.response.ResponseReporteProduccionDTO;
import com.example.produccion.service.ReporteProduccionService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reporteProduccion")
public class ReporteProduccionController {

    @Autowired
    private ReporteProduccionService reporteService;

    @PostMapping("/generar")
    public ResponseEntity<ResponseReporteProduccionDTO> generarReporte(@Valid @RequestBody RequestReporteProduccionDTO request) {
        ResponseReporteProduccionDTO response = reporteService.generarReporte(request);
        return ResponseEntity.ok(response);
    }
}


