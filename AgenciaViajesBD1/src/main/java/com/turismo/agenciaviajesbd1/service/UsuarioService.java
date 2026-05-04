package com.turismo.agenciaviajesbd1.service;

import com.turismo.agenciaviajesbd1.dto.LoginRequestDTO;
import com.turismo.agenciaviajesbd1.dto.LoginResponseDTO;
import com.turismo.agenciaviajesbd1.model.Usuario;
import com.turismo.agenciaviajesbd1.repository.UsuarioRepository;
import com.turismo.agenciaviajesbd1.security.JwtUtil;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder) {

        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
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

        usuario.setContraseña(
                passwordEncoder.encode(
                        usuario.getContraseña()));

        return usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public LoginResponseDTO login(LoginRequestDTO request) {

        Usuario usuario = usuarioRepository
                .findByCorreo(request.getCorreo())
                .orElseThrow(() ->
                        new RuntimeException("Correo no encontrado"));

        if (!passwordEncoder.matches(
                request.getContraseña(),
                usuario.getContraseña())) {

            throw new RuntimeException(
                    "Contraseña incorrecta");
        }

        String token = JwtUtil.generateToken(
                usuario.getCorreo());

        return new LoginResponseDTO(token);
    }
}