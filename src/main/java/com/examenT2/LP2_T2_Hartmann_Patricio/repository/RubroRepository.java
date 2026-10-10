package com.examenT2.LP2_T2_Hartmann_Patricio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examenT2.LP2_T2_Hartmann_Patricio.model.RubroHartmannPatricio;

@Repository
public interface RubroRepository extends JpaRepository<RubroHartmannPatricio, Integer> {
}
