package com.example.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "historial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistorialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "idAuto", nullable = false)
    private AutoEntity auto;
    private String estado;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private Integer tipoReparacion;
    private Integer montoTotal;
    private LocalDate fechaCliente;
}