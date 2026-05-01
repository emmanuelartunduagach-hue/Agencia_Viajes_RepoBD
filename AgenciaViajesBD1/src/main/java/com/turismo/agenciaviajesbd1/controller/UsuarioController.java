package com.turismo.agenciaviajesbd1.controller;
import com.turismo.agenciaviajesbd1.dto.LoginRequestDTO;
import com.turismo.agenciaviajesbd1.dto.LoginResponseDTO;
import com.turismo.agenciaviajesbd1.dto.UsuarioDTO;
import com.turismo.agenciaviajesbd1.model.Usuario;
import com.turismo.agenciaviajesbd1.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UsuarioDTO> listarUsuarios() {

        return usuarioService.listarUsuarios()
                .stream()
                .map(usuario -> new UsuarioDTO(
                        usuario.getIdUsuario(),
                        usuario.getNombre(),
                        usuario.getCorreo(),
                        usuario.getRol(),
                        usuario.getEstado()
                ))
                .toList();
    }

    @GetMapping("/{id}")
    public Optional<Usuario> obtenerPorId(@PathVariable Integer id) {
        return usuarioService.obtenerPorId(id);
    }

    @GetMapping("/correo/{correo}")
    public Optional<Usuario> buscarPorCorreo(@PathVariable String correo) {
        return usuarioService.buscarPorCorreo(correo);
    }

    @PostMapping
    public Usuario guardarUsuario(@Valid @RequestBody Usuario usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    @PostMapping("/login")
    public LoginResponseDTO login(
            @RequestBody LoginRequestDTO request) {

        return usuarioService.login(request);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Integer id) {
        usuarioService.eliminarUsuario(id);
    }
}
