package com.panaderia.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.panaderia.system.model.ViewAccesos;

@Repository
public interface ViewAccesosRepository extends JpaRepository<ViewAccesos, Integer> {

}

