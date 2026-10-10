package com.examenT2.LP2_T2_Hartmann_Patricio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examenT2.LP2_T2_Hartmann_Patricio.model.OrdenCompraHartmannPatricio;

@Repository
public interface OrdenCompraRepository extends JpaRepository<OrdenCompraHartmannPatricio, Integer> {

	List<OrdenCompraHartmannPatricio> findAllByOrderByNroOrdenDesc();

}
