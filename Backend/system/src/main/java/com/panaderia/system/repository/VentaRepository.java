package com.panaderia.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.panaderia.system.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {

}
