package com.turismo.agenciaviajesbd1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "guia_tour")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class GuiaTour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_guia_tour")
    private Integer idGuiaTour;

    @ManyToOne
    @JoinColumn(name = "id_guia")
    private Guia guia;

    @ManyToOne
    @JoinColumn(name = "id_tour")
    private Tour tour;

    @Column(name = "fecha_asignacion")
    private LocalDate fechaAsignacion;

    @Column(name = "disponible")
    private Boolean disponible;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "agencia")
    private String agencia;

}
