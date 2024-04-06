package com.example.services;


import java.util.Arrays;
import java.util.List;

import com.example.entities.HistorialEntity;
import com.example.services.HistorialService;
import com.example.services.AutoService;
import com.example.Logica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostoService {
    Logica logic = new Logica();

    @Autowired
    AutoService autoService;

    @Autowired
    HistorialService historialService;

    public Integer costoReparaciones(String patente){
        List<HistorialEntity> historiales = historialService.getHistorialesActivos(autoService.getHistorial(patente));

    }

    /*
    obtenerTipoMotor
    calcularCostoReparaciones
    obtenerHistorialTodasLasReparaciones(patente) - ultima;
    filtrarPor12meses;
    contarReparacionesRealizadas;
    verificarTipoMotor;
    aplicarDescuentoXReparaciones
    verificarHoraLocal_servidor;
    verificarAñoVehiculo;
    obtenerModeloVehiculo
    aplicarRecargoAntiguedad;
    obtenerkilometrajexMODELO
    aplicarRecargoKilometraje
    EntregarTotal
    */

}
