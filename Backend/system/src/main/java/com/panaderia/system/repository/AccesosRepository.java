package com.panaderia.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.panaderia.system.model.Accesos;

@Repository
public interface AccesosRepository extends JpaRepository<Accesos, Integer> {

      
    @Transactional
    void deleteByIdperfil(Integer idperfil);
}

