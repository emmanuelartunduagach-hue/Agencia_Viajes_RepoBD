package com.turismo.agenciaviajesbd1.repository;

import com.turismo.agenciaviajesbd1.model.Cliente;
import com.turismo.agenciaviajesbd1.model.EstadoReserva;
import com.turismo.agenciaviajesbd1.model.Reserva;
import com.turismo.agenciaviajesbd1.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    Optional<Reserva> findByCodigoReserva(String codigoReserva);

    List<Reserva> findByCliente(Cliente cliente);

    List<Reserva> findByEstado(EstadoReserva estado);

    List<Reserva> findByCreadoPor(Usuario usuario);


}
