package com.example.services;


import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.example.entities.AutoEntity;
import com.example.entities.HistorialEntity;
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

    public Integer getCostoReparacion(String modelo, Integer nReparacion){
        return logic.getCostoReparacion(modelo,nReparacion);
    }


    public Integer cantidadReparaciones(String patente, LocalDate fecha){
        List<HistorialEntity> historiales = historialService.getHistorialesInactivos(autoService.getHistorial(patente));
        historiales = historialService.getHistoriales12Meses(historiales, fecha);
        return historiales.size();
    }

    public Double getDescuentoXReparaciones(String patente){
        return logic.getDescuentoReparaciones(autoService.getTipoMotorByPatente(patente), cantidadReparaciones(patente,LocalDate.now()));
    }

    public Double getRecargoXAntiguedad(String patente){
        AutoEntity auto = autoService.getAutoByPatente(patente);
        return logic.getRecargoAntiguedad(auto.getTipo(), auto.getAnoFabricacion());
    }
    public double getRecargoXKilometraje(String patente){
        AutoEntity auto = autoService.getAutoByPatente(patente);
        return logic.getRecargoKilometraje(auto.getTipo(), auto.getKilometraje());
    }
    public double getDescuentoXdia(){
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DayOfWeek diaSemana = fechaHoraActual.getDayOfWeek();
        int hora = fechaHoraActual.getHour();

        if (diaSemana.getValue() >= 1 && diaSemana.getValue() <= 4 && hora >= 9 && hora < 12) {
            // Realizar aquí la lógica para el descuento en este horario y día
            return logic.getDescuentoDiaEspecial();
        } else {
            return 0.0; // Devolver 0 si no se cumple la condición
        }
    }

    public Double getCostoTotal(String patente){
        Double iva = 1.19;
        Integer cr = costoReparaciones(patente);
        Double dr = getDescuentoXReparaciones(patente) * cr;
        Double dd = getDescuentoXdia()* cr;
        Double ra = getRecargoXAntiguedad(patente)* (cr- (dr+dd));
        Double rk = getRecargoXKilometraje(patente)* (cr- (dr+dd));
        Double costoTotal = (cr-(dr+dd)+ (ra+rk) )* iva;

        return costoTotal;
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
