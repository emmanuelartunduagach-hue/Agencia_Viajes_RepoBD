package com.turismo.agenciaviajesbd1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "disponibilidad")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Disponibilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disponibilidad")
    private Integer idDisponibilidad;

    @ManyToOne
    @JoinColumn(name = "id_tour")
    private Tour tour;

    @Column(name = "fecha_especifica")
    private LocalDate fechaEspecifica;

    @Column(name = "cupo_maximo")
    private Integer cupoMaximo;

    @Column(name = "cupo_disponible")
    private Integer cupoDisponible;

    @Column(name = "precio_especial")
    private BigDecimal precioEspecial;

}
