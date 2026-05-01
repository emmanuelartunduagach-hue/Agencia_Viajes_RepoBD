package com.turismo.agenciaviajesbd1.service;

import com.turismo.agenciaviajesbd1.model.Usuario;
import com.turismo.agenciaviajesbd1.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import com.turismo.agenciaviajesbd1.security.JwtUtil;
import com.turismo.agenciaviajesbd1.dto.LoginRequestDTO;
import com.turismo.agenciaviajesbd1.dto.LoginResponseDTO;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> obtenerPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> buscarPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Integer id) {
        usuarioRepository.deleteById(id);

    }

}
