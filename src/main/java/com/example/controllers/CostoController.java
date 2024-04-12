package com.example.controllers;


import com.example.entities.AutoEntity;
import com.example.entities.HistorialEntity;
import com.example.services.AutoService;
import com.example.services.CostoService;
import org.json.JSONArray;
import org.json.JSONObject;



import com.example.services.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    public ResponseEntity<?> getCalculos(@PathVariable String patente) {
            Integer cr = costoService.costoReparaciones(patente);
            Double dr = costoService.getDescuentoXReparaciones(patente) * cr;
            Double dd = costoService.getDescuentoXdia()* cr;
            Double ra = costoService.getRecargoXAntiguedad(patente)* (cr- (dr+dd));
            Double rk = costoService.getRecargoXKilometraje(patente)* (cr- (dr+dd));
            Integer costo = costoService.getCostoTotal(patente).intValue();
            JSONObject responseObject = new JSONObject();
            responseObject.put("costo_reparaciones", cr);
            responseObject.put("descuento_dia", dd);
            responseObject.put("descuento_reparaciones", dr);
            responseObject.put("recargo_antiguedad", ra);
            responseObject.put("recargo_kilometraje", rk);
            responseObject.put("costo", costo );
            return ResponseEntity.ok(responseObject.toString());
    }


    @GetMapping("/tipo")
    public ResponseEntity<?> getTipoVsReparaciones() {
        String[] tipos = {"Sedan","Hatchback","SUV","Pickup","Furgoneta"};

        JSONArray lista = new JSONArray();

        for (int i = 1; i <= 11; i++) {
            JSONObject responseJson = new JSONObject();
            int total = 0;
            for (String tipo : tipos) {
                int sumaMontoTotal = 0;
                List<HistorialEntity> historiales = historialService.findByTipoReparacionAndAutoTipo(tipo, i);
                sumaMontoTotal += historialService.sumarMontoTotalHistoriales(historiales);
                responseJson.put(tipo, sumaMontoTotal);
                total += sumaMontoTotal;
            }
            responseJson.put("total_columna", total);
            responseJson.put("tipo_reparacion", i);
            lista.put(responseJson);
        }

        return ResponseEntity.ok(lista.toString());
    }

    @GetMapping("/tipoMotorVsReparaciones")
    public ResponseEntity<?> getTipoMotorVsReparaciones() {
        String[] tipos = {"Gasolina","Diesel","Hibrido","Electrico"};

        JSONArray lista = new JSONArray();

        for (int i = 1; i <= 11; i++) {
            JSONObject responseJson = new JSONObject();
            int total = 0;
            for (String tipo : tipos) {
                int sumaMontoTotal = 0;
                List<HistorialEntity> historiales = historialService.findByTipoReparacionAndAutoTipoMotor(tipo, i);
                sumaMontoTotal += historialService.sumarMontoTotalHistoriales(historiales);
                responseJson.put(tipo, sumaMontoTotal);
                total += sumaMontoTotal;
            }
            responseJson.put("total_columna", total);
            responseJson.put("tipo_reparacion", i);
            lista.put(responseJson);
        }

        return ResponseEntity.ok(lista.toString());
    }

}
