package com.panaderia.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.panaderia.system.model.ViewModulosPadre;

@Repository
public interface ViewModulosPadreRepository extends JpaRepository<ViewModulosPadre, Integer> {

}

