package com.example.repositories;


import com.example.entities.HistorialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;


@Repository
public interface HistorialRepository extends JpaRepository<HistorialEntity, Long> {

    public HistorialEntity findByid(Long id);
    public default List<HistorialEntity> findHistorialActivo(List<HistorialEntity> historiales){
        return historiales.stream()
                .filter(historial -> "activo".equals(historial.getEstado()))
                .collect(Collectors.toList());
    }
}
