package com.examenT2.LP2_T2_Hartmann_Patricio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examenT2.LP2_T2_Hartmann_Patricio.model.ProveedorHartmannPatricio;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorHartmannPatricio, Integer> {
}
