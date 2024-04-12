package com.example.repositories;


import com.example.entities.HistorialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Repository
public interface HistorialRepository extends JpaRepository<HistorialEntity, Long> {

     HistorialEntity findByid(Long id);
    @Query("SELECT h FROM HistorialEntity h WHERE h.tipo_reparacion = :tipoReparacion AND h.auto.tipo = :tipoAuto")
    List<HistorialEntity> findByTipoReparacionAndAutoTipo(@Param("tipoReparacion") Integer tipoReparacion, @Param("tipoAuto") String tipoAuto);


    @Query("SELECT h FROM HistorialEntity h WHERE h.tipo_reparacion = :tipoReparacion AND h.auto.tipo_motor = :tipoMotorAuto")
    List<HistorialEntity> findByTipoReparacionAndAutoTipoMotor(@Param("tipoReparacion") Integer tipoReparacion, @Param("tipoMotorAuto") String tipoMotorAuto);
    default List<HistorialEntity> findHistorialEstado(List<HistorialEntity> historiales, String estado){
        return historiales.stream()
                .filter(historial -> estado.equals(historial.getEstado()))
                .collect(Collectors.toList());
    }

    @Query("SELECT SUM(h.monto_total) FROM HistorialEntity h")
    Integer sumarMontoTotalDeHistoriales();

     default List<HistorialEntity> findHistorialMeses(List<HistorialEntity> historiales, LocalDate fecha, Integer meses){
        LocalDate fechaLimite = fecha.minusMonths(meses);
        return historiales.stream()
                .filter(historial -> !historial.getFecha_ingreso().isBefore(fechaLimite))
                .collect(Collectors.toList());
    }

     default Integer getCostoHistoriales(List<HistorialEntity> historiales){
        Integer costoTotal = 0;
        for (HistorialEntity historial : historiales) {
            costoTotal += historial.getMonto_total();
        }
        return costoTotal;
    }
}
