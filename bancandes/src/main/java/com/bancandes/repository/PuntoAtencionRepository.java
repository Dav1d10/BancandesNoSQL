package com.bancandes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancandes.entities.PuntoAtencionEntity;

public interface PuntoAtencionRepository extends JpaRepository<PuntoAtencionEntity, Integer>{
    
}
