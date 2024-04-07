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
    public List<HistorialEntity> getHistorialesActivos(List<HistorialEntity> historiales){ return historialRepository.findHistorialEstado(historiales, "activo");}
    public List<HistorialEntity> getHistorialesInactivos(List<HistorialEntity> historiales){ return historialRepository.findHistorialEstado(historiales, "inactivo");}

    public List<HistorialEntity> getHistoriales12Meses(List<HistorialEntity> historiales, LocalDate fecha){ return historialRepository.findHistorialMeses(historiales, fecha, 12);}
    public HistorialEntity guardarHistorial(HistorialEntity historial){return historialRepository.save(historial);}

    public Integer costoTotalHistorialesActivos(List<HistorialEntity> historiales){return historialRepository.getCostoHistoriales(historiales);}

}
