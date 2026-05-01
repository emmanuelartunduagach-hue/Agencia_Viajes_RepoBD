package com.turismo.agenciaviajesbd1.service;

import com.turismo.agenciaviajesbd1.model.Cliente;
import com.turismo.agenciaviajesbd1.model.EstadoReserva;
import com.turismo.agenciaviajesbd1.model.Reserva;
import com.turismo.agenciaviajesbd1.model.Usuario;
import com.turismo.agenciaviajesbd1.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<Reserva> listarReservas() {
        return reservaRepository.findAll();
    }

    public Optional<Reserva> obtenerPorId(Integer id) {
        return reservaRepository.findById(id);
    }

    public Optional<Reserva> buscarPorCodigo(String codigo) {
        return reservaRepository.findByCodigoReserva(codigo);
    }

    public List<Reserva> buscarPorCliente(Cliente cliente) {
        return reservaRepository.findByCliente(cliente);
    }

    public List<Reserva> buscarPorEstado(EstadoReserva estado) {
        return reservaRepository.findByEstado(estado);
    }

    public List<Reserva> buscarPorUsuario(Usuario usuario) {
        return reservaRepository.findByCreadoPor(usuario);
    }

    public Reserva guardarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public void eliminarReserva(Integer id) {
        reservaRepository.deleteById(id);
    }
}
