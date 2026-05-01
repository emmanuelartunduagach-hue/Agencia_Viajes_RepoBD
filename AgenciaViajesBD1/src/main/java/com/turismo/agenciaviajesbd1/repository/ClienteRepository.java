package com.turismo.agenciaviajesbd1.repository;

import com.turismo.agenciaviajesbd1.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}