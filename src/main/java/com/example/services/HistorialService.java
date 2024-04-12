package com.example.services;


import com.example.entities.HistorialEntity;
import com.example.repositories.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HistorialService {

    @Autowired
    HistorialRepository historialRepository;

    public HistorialEntity getHistorialByid(Long id ){
        return historialRepository.findByid(id);
    }
    public List<HistorialEntity> getHistorialesActivos(List<HistorialEntity> historiales){ return historialRepository.findHistorialEstado(historiales, "Activo");}
    public List<HistorialEntity> getHistorialesInactivos(List<HistorialEntity> historiales){ return historialRepository.findHistorialEstado(historiales, "Inactivo");}

    public List<HistorialEntity> findByTipoReparacionAndAutoTipo(String tipo_auto, Integer nReparacion){return historialRepository.findByTipoReparacionAndAutoTipo(nReparacion,tipo_auto);}

    public List<HistorialEntity> findByTipoReparacionAndAutoTipoMotor(String tipoMotor_auto, Integer nReparacion){return historialRepository.findByTipoReparacionAndAutoTipoMotor(nReparacion,tipoMotor_auto);}

    public Integer sumarMontoTotalHistoriales(List<HistorialEntity> historiales){
        int sumaMontoTotal = historiales.stream()
                .mapToInt(HistorialEntity::getMonto_total)
                .sum();
        return sumaMontoTotal;};
    public List<HistorialEntity> getHistoriales12Meses(List<HistorialEntity> historiales, LocalDate fecha){ return historialRepository.findHistorialMeses(historiales, fecha, 12);}
    public HistorialEntity guardarHistorial(HistorialEntity historial){return historialRepository.save(historial);}

    public Integer costoTotalHistorialesActivos(List<HistorialEntity> historiales){return historialRepository.getCostoHistoriales(historiales);}

}
