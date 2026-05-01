package com.turismo.agenciaviajesbd1.controller;

import com.turismo.agenciaviajesbd1.model.Categoria;
import com.turismo.agenciaviajesbd1.model.Estado;
import com.turismo.agenciaviajesbd1.model.Tour;
import com.turismo.agenciaviajesbd1.service.TourService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tours")
@CrossOrigin("*")
public class TourController {

    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping
    public List<Tour> listarTours() {
        return tourService.listarTours();
    }

    @GetMapping("/{id}")
    public Optional<Tour> obtenerPorId(@PathVariable Integer id) {
        return tourService.obtenerPorId(id);
    }

    @GetMapping("/estado/{estado}")
    public List<Tour> buscarPorEstado(@PathVariable Estado estado) {
        return tourService.buscarPorEstado(estado);
    }

    @GetMapping("/nombre/{nombre}")
    public List<Tour> buscarPorNombre(@PathVariable String nombre) {
        return tourService.buscarPorNombre(nombre);
    }

    @PostMapping
    public Tour guardarTour(@RequestBody Tour tour) {
        return tourService.guardarTour(tour);
    }

    @DeleteMapping("/{id}")
    public void eliminarTour(@PathVariable Integer id) {
        tourService.eliminarTour(id);
    }
}
