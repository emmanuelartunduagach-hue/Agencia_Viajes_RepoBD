package com.turismo.agenciaviajesbd1.repository;

import com.turismo.agenciaviajesbd1.model.Categoria;
import com.turismo.agenciaviajesbd1.model.Estado;
import com.turismo.agenciaviajesbd1.model.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {

    List<Tour> findByEstado(Estado estado);

    List<Tour> findByCategoria(Categoria categoria);

    List<Tour> findByNombreContainingIgnoreCase(String nombre);



}
