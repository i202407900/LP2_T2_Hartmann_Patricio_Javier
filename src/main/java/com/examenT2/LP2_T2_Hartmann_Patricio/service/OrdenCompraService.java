package com.examenT2.LP2_T2_Hartmann_Patricio.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.examenT2.LP2_T2_Hartmann_Patricio.dto.ResultadoResponse;
import com.examenT2.LP2_T2_Hartmann_Patricio.model.OrdenCompraHartmannPatricio;
import com.examenT2.LP2_T2_Hartmann_Patricio.repository.OrdenCompraRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrdenCompraService {

	private final OrdenCompraRepository ordenCompraRepository;

	public List<OrdenCompraHartmannPatricio> getAll() {
		return ordenCompraRepository.findAllByOrderByNroOrdenDesc();
	}

	public OrdenCompraHartmannPatricio getOne(Integer id) {
		return ordenCompraRepository.findById(id).orElse(null);
	}

	@Transactional
	public ResultadoResponse create(OrdenCompraHartmannPatricio ordenCompra) {
		try {
			var registrada = ordenCompraRepository.save(ordenCompra);
			var mensaje = String.format("Orden de compra Nro. %d registrada.", registrada.getNroOrden());
			return new ResultadoResponse(true, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transacción");
		}
	}

	@Transactional
	public ResultadoResponse update(OrdenCompraHartmannPatricio ordenCompra) {
		try {
			var actualizada = ordenCompraRepository.save(ordenCompra);
			var mensaje = String.format("Orden de compra Nro. %d actualizada.", actualizada.getNroOrden());
			return new ResultadoResponse(true, mensaje);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultadoResponse(false, "Hubo un error en la transacción");
		}
	}

}
