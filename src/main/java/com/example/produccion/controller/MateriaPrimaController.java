package com.example.produccion.controller;

import com.example.produccion.dto.request.RequestMateriaPrimaDTO;
import com.example.produccion.dto.response.ResponseMateriaPrimaDTO;
import com.example.produccion.service.MateriaPrimaService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/materiaPrima")
public class MateriaPrimaController {

    @Autowired
    private MateriaPrimaService materiaPrimaService;

    @PostMapping("/solicitar")
    public ResponseEntity<ResponseMateriaPrimaDTO> solicitarMateriaPrima(@Valid @RequestBody RequestMateriaPrimaDTO request) {
        ResponseMateriaPrimaDTO response = materiaPrimaService.solicitarMateriaPrima(request);
        return ResponseEntity.ok(response);
    }
}



