package com.example.produccion.controller;

import com.example.produccion.dto.request.RequestInspeccionProductoDTO;
import com.example.produccion.dto.response.ResponseInspeccionProductoDTO;
import com.example.produccion.service.InspeccionProductoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class InspeccionProductoController {

    @Autowired
    private InspeccionProductoService inspeccionService;

    @PostMapping("/inspeccionar")
    public ResponseEntity<ResponseInspeccionProductoDTO> inspeccionarProducto(@Valid @RequestBody RequestInspeccionProductoDTO request) {
        ResponseInspeccionProductoDTO response = inspeccionService.inspeccionarProducto(request);
        return ResponseEntity.ok(response);
    }
}


