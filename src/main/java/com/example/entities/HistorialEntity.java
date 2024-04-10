package com.example.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "historial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistorialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    @JsonIgnore
    private AutoEntity auto;
    private String patente;
    private String estado;
    private Integer tipo_reparacion;
    private Integer monto_total;
    private LocalDate fecha_ingreso;
    private LocalDate fecha_salida;
    private LocalDate fecha_cliente;
    private LocalTime hora_ingreso;
    private LocalTime hora_salida_reparacion;
    private LocalTime hora_salida_cliente;
}

/*
estado
:
"Activo"
fecha_cliente
:
"2024-04-10"
fecha_ingreso
:
"2024-04-10"
fecha_salida
:
"2024-04-10"
hora_ingreso
:
"22:12:24"
hora_salida_cliente
:
"22:12:24"
hora_salida_reparacion
:
"22:12:24"
monto_total
:
""
patente
:
"HFKD21"
tipo_reparacion
:
""
 */