package com.turismo.agenciaviajesbd1.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_usuario")
        private Integer idUsuario;

        @Column(name = "nombre")
        private String nombre;

        @Column(name = "correo", unique = true)
        private String correo;

        @Column(name = "contraseña")
        private String contraseña;

        @Enumerated(EnumType.STRING)
        @Column(name = "rol")
        private Rol rol;

        @Enumerated(EnumType.STRING)
        @Column(name = "estado")
        private Estado estado;

        @Column(name = "fecha_creacion")
        private LocalDateTime fechaCreacion;

}
