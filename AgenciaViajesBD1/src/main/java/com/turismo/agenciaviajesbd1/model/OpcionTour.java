package com.turismo.agenciaviajesbd1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "opcion_tour")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class OpcionTour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_opcion")
    private Integer idOpcion;

    @ManyToOne
    @JoinColumn(name = "id_tour")
    private Tour tour;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_acomodacion")
    private TipoAcomodacion tipoAcomodacion;

    @Column(name = "precio_base")
    private BigDecimal precioBase;

    @Column(name = "precio_transporte")
    private BigDecimal precioTransporte;

    @Column(name = "activo")
    private Boolean activo;

}
