package com.panaderia.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.panaderia.system.model.Perfiles;

@Repository
public interface PerfilesRepository extends JpaRepository<Perfiles, Integer> {

}

