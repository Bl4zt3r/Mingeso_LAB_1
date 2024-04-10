package com.example.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    @JsonIgnore
    private List<HistorialEntity> historial;
}
