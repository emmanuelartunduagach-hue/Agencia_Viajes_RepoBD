package com.turismo.agenciaviajesbd1.dto;


import com.turismo.agenciaviajesbd1.model.Estado;
import com.turismo.agenciaviajesbd1.model.Rol;

public class UsuarioDTO {

    private Integer idUsuario;
    private String nombre;
    private String correo;
    private Rol rol;
    private Estado estado;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Integer idUsuario, String nombre, String correo,
                      Rol rol, Estado estado) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.rol = rol;
        this.estado = estado;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
