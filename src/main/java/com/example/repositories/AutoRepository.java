package com.example.repositories;

import com.example.entities.AutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoRepository extends JpaRepository<AutoEntity, Long> {
    public AutoEntity findByPatente(String patente);

}