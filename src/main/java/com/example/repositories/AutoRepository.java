package com.example.repositories;

import com.example.entities.AutoEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoRepository extends JpaRepository<AutoEntity, Long> {
    AutoEntity findByPatente(String patente);

    @Query("SELECT a.tipo FROM AutoEntity a")
    List<String> findAllTipos();

    boolean existsByPatente(String patente);
}