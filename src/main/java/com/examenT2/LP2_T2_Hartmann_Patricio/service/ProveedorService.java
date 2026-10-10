package com.examenT2.LP2_T2_Hartmann_Patricio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examenT2.LP2_T2_Hartmann_Patricio.model.ProveedorHartmannPatricio;
import com.examenT2.LP2_T2_Hartmann_Patricio.repository.ProveedorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorService {

	private final ProveedorRepository proveedorRepository;

	public List<ProveedorHartmannPatricio> getAll() {
		return proveedorRepository.findAll();
	}

}
