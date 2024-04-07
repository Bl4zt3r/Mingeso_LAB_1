package com.example.repositories;


import com.example.entities.HistorialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public interface HistorialRepository extends JpaRepository<HistorialEntity, Long> {

     HistorialEntity findByid(Long id);
     default List<HistorialEntity> findHistorialEstado(List<HistorialEntity> historiales, String estado){
        return historiales.stream()
                .filter(historial -> estado.equals(historial.getEstado()))
                .collect(Collectors.toList());
    }

     default List<HistorialEntity> findHistorialMeses(List<HistorialEntity> historiales, LocalDate fecha, Integer meses){
        LocalDate fechaLimite = fecha.minusMonths(meses);
        return historiales.stream()
                .filter(historial -> !historial.getFechaIngreso().isBefore(fechaLimite))
                .collect(Collectors.toList());
    }

     default Integer getCostoHistoriales(List<HistorialEntity> historiales){
        Integer costoTotal = 0;
        for (HistorialEntity historial : historiales) {
            costoTotal += historial.getMontoTotal();
        }
        return costoTotal;
    }
}
