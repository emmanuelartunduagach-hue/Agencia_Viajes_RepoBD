package com.turismo.agenciaviajesbd1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "reserva")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Integer idReserva;

    @Column(name = "codigo_reserva", unique = true)
    private String codigoReserva;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_disponibilidad")
    private Disponibilidad disponibilidad;

    @ManyToOne
    @JoinColumn(name = "id_opcion")
    private OpcionTour opcionTour;

    @Column(name = "fecha_reserva")
    private LocalDateTime fechaReserva;

    @Column(name = "hora_tour")
    private LocalTime horaTour;

    @Column(name = "cantidad_personas")
    private Integer cantidadPersonas;

    @Column(name = "precio_total")
    private BigDecimal precioTotal;

    @Column(name = "descuento")
    private BigDecimal descuento;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private EstadoReserva estado;

    @Column(name = "notas", columnDefinition = "TEXT")
    private String notas;

    @ManyToOne
    @JoinColumn(name = "creado_por")
    private Usuario creadoPor;


}
