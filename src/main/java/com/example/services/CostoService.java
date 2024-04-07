package com.example.services;


import java.time.LocalDate;
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
        return historialService.costoTotalHistorialesActivos(historiales);
    }

    public Integer cantidadReparaciones(String patente, LocalDate fecha){
        List<HistorialEntity> historiales = historialService.getHistorialesInactivos(autoService.getHistorial(patente));
        historiales = historialService.getHistoriales12Meses(historiales, fecha);
        return historiales.size();
    }

    public Double getDescuentoXReparaciones(String patente, LocalDate fecha){
        return logic.getDescuentoReparaciones(autoService.getTipoMotorByPatente(patente), cantidadReparaciones(patente,fecha));
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
