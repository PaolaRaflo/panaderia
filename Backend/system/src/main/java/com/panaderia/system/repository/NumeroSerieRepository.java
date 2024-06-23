package com.panaderia.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.panaderia.system.model.NumeroSerie;

@Repository
public interface NumeroSerieRepository extends JpaRepository<NumeroSerie, Integer> {
}
