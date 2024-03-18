package com.bancandes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bancandes.entities.CuentaEntity;

public interface CuentaRepository extends JpaRepository<CuentaEntity, Integer> {

}