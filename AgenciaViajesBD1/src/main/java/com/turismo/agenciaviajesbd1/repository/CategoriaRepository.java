package com.turismo.agenciaviajesbd1.repository;

import com.turismo.agenciaviajesbd1.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
