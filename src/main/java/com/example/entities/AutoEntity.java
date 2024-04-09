package com.example.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "autos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(unique = true, nullable = false)
    private String patente;
    private String modelo;
    private String marca;
    private String tipo;
    private Integer anoFabricacion;
    private Integer kilometraje;
    private String tipo_motor;
    private Integer n_asientos;
    @OneToMany
    private List<HistorialEntity> historial;
}
