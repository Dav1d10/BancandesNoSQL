package com.bancandes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancandes.entities.PrestamoEntity;

public interface PrestamoRepository extends JpaRepository<PrestamoEntity, Integer>{
    
}
