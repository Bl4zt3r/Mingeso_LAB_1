package com.example.entities;
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
    private AutoEntity auto;
    private String patente;
    private String estado;
    private Integer tipoReparacion;
    private Integer montoTotal;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalidaReparacion;
    private LocalDate fechaSalidaCliente;
    private LocalTime horaIngreso;
    private LocalTime horaSalidaReparacion;
    private LocalTime horaSalidaCliente;
}