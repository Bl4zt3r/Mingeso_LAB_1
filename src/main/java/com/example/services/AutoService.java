package com.example.services;


import com.example.entities.AutoEntity;
import com.example.entities.HistorialEntity;
import com.example.repositories.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AutoService {

    @Autowired
    AutoRepository autoRepository;

    public AutoEntity getAutoByPatente(String patente){
        return autoRepository.findByPatente(patente);
    }
    public Integer getKilometrajeByPatente(String patente){
        return autoRepository.findByPatente(patente).getKilometraje();
    }

    public String getTipoMotorByPatente(String patente){
        return autoRepository.findByPatente(patente).getTipoMotor();
    }

    public List<HistorialEntity> getHistorial(String patente){
        return autoRepository.findByPatente(patente).getHistorial();
    }

    public AutoEntity guardarAuto(AutoEntity auto){
        return autoRepository.save(auto);
    }


}