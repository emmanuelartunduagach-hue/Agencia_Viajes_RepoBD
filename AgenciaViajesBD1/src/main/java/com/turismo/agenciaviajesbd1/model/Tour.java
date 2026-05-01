package com.turismo.agenciaviajesbd1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "tour")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tour")
    private Integer idTour;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "duracion")
    private String duracion;

    @Column(name = "punto_encuentro")
    private String puntoEncuentro;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel_dificultad")
    private NivelDificultad nivelDificultad;

    @Column(name = "requisitos", columnDefinition = "TEXT")
    private String requisitos;

    @Column(name = "incluye", columnDefinition = "TEXT")
    private String incluye;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estado estado;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;


}
