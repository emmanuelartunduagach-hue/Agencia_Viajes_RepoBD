package com.turismo.agenciaviajesbd1.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "guia")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Guia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_guia")
    private Integer idGuia;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(name = "especialidad")
    private String especialidad;

    @Column(name = "idiomas")
    private String idiomas;

    @Column(name = "telefono")
    private String telefono;


}
