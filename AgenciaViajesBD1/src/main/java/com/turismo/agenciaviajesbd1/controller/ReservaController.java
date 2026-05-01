package com.turismo.agenciaviajesbd1.controller;

import com.turismo.agenciaviajesbd1.model.Cliente;
import com.turismo.agenciaviajesbd1.model.EstadoReserva;
import com.turismo.agenciaviajesbd1.model.Reserva;
import com.turismo.agenciaviajesbd1.model.Usuario;
import com.turismo.agenciaviajesbd1.service.ReservaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin("*")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public List<Reserva> listarReservas() {
        return reservaService.listarReservas();
    }

    @GetMapping("/{id}")
    public Optional<Reserva> obtenerPorId(@PathVariable Integer id) {
        return reservaService.obtenerPorId(id);
    }

    @GetMapping("/codigo/{codigo}")
    public Optional<Reserva> buscarPorCodigo(@PathVariable String codigo) {
        return reservaService.buscarPorCodigo(codigo);
    }

    @GetMapping("/estado/{estado}")
    public List<Reserva> buscarPorEstado(@PathVariable EstadoReserva estado) {
        return reservaService.buscarPorEstado(estado);
    }

    @PostMapping
    public Reserva guardarReserva(@RequestBody Reserva reserva) {
        return reservaService.guardarReserva(reserva);
    }

    @DeleteMapping("/{id}")
    public void eliminarReserva(@PathVariable Integer id) {
        reservaService.eliminarReserva(id);
    }
}
