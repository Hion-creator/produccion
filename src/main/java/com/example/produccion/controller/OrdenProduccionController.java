package com.example.produccion.controller;

import com.example.produccion.dto.request.RequestOrdenProduccionDTO;
import com.example.produccion.dto.response.ResponseOrdenProduccionDTO;
import com.example.produccion.service.OrdenProduccionService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/ordenProduccion")
public class OrdenProduccionController {

    @Autowired
    private OrdenProduccionService ordenService;

    @PostMapping("/crear")
    public ResponseEntity<ResponseOrdenProduccionDTO> crearOrden(@Valid @RequestBody RequestOrdenProduccionDTO request) {
        ResponseOrdenProduccionDTO response = ordenService.crearOrden(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ResponseOrdenProduccionDTO>> listarOrdenes() {
        List<ResponseOrdenProduccionDTO> lista = ordenService.listarOrdenes();
        return ResponseEntity.ok(lista);
    }
}

