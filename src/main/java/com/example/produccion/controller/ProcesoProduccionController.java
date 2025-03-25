package com.example.produccion.controller;

import com.example.produccion.dto.request.RequestProcesoProduccionDTO;
import com.example.produccion.dto.response.ResponseProcesoProduccionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/procesoProduccion")
public class ProcesoProduccionController {

    @PostMapping("/iniciar")
    public ResponseEntity<ResponseProcesoProduccionDTO> iniciarProceso(@RequestBody RequestProcesoProduccionDTO request) {
        // Lógica simulada: parsear fecha, buscar órdenes en estado "Inicial", validar inventario, etc.
        ResponseProcesoProduccionDTO response = new ResponseProcesoProduccionDTO();
        response.setMensaje("Proceso de producción iniciado correctamente");
        response.setOrdenesProcesadas(3);
        return ResponseEntity.ok(response);
    }
}

