package com.panaderia.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.panaderia.system.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}

