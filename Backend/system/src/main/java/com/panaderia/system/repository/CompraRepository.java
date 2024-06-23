package com.panaderia.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.panaderia.system.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {

}
