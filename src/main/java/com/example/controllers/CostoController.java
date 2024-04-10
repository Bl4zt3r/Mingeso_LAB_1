package com.example.controllers;


import com.example.entities.AutoEntity;
import com.example.entities.HistorialEntity;
import com.example.services.AutoService;
import com.example.services.CostoService;


import com.example.services.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/costos")
@CrossOrigin("*")
public class CostoController {

    @Autowired
    CostoService costoService;
    @Autowired
    AutoService autoService;
    @Autowired
    HistorialService historialService;

    @GetMapping("/{patente}")

    public ResponseEntity<List<HistorialEntity>> getCalculos(@PathVariable String patente) {
        AutoEntity auto = autoService.getAutoByPatente(patente);
        if (auto != null) {
            return ResponseEntity.ok(auto.getHistorial());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
