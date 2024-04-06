package com.example.services;

import com.example.entities.HistorialEntity;
import com.example.repositories.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialService {

    @Autowired
    HistorialRepository historialRepository;

    public HistorialEntity getHistorialByid(Long id ){
        return historialRepository.findByid(id);
    }

    public List<HistorialEntity> getHistorialesActivos(List<HistorialEntity> historiales){ return historialRepository.findHistorialActivo(historiales);}
    public HistorialEntity guardarHistorial(HistorialEntity historial){
        return historialRepository.save(historial);
    }
}
