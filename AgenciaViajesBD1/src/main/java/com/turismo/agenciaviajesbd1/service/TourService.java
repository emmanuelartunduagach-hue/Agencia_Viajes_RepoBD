package com.turismo.agenciaviajesbd1.service;

import com.turismo.agenciaviajesbd1.model.Categoria;
import com.turismo.agenciaviajesbd1.model.Estado;
import com.turismo.agenciaviajesbd1.model.Tour;
import com.turismo.agenciaviajesbd1.repository.TourRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TourService {

    private final TourRepository tourRepository;

    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public List<Tour> listarTours() {
        return tourRepository.findAll();
    }

    public Optional<Tour> obtenerPorId(Integer id) {
        return tourRepository.findById(id);
    }

    public List<Tour> buscarPorEstado(Estado estado) {
        return tourRepository.findByEstado(estado);
    }

    public List<Tour> buscarPorCategoria(Categoria categoria) {
        return tourRepository.findByCategoria(categoria);
    }

    public List<Tour> buscarPorNombre(String nombre) {
        return tourRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public Tour guardarTour(Tour tour) {
        return tourRepository.save(tour);
    }

    public void eliminarTour(Integer id) {
        tourRepository.deleteById(id);
    }
}
