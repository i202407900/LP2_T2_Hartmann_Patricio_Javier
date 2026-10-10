package com.examenT2.LP2_T2_Hartmann_Patricio.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_orden_compra")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdenCompraHartmannPatricio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "nro_orden")
	private Integer nroOrden;

	@ManyToOne
	@JoinColumn(name = "id_proveedor", nullable = false)
	private ProveedorHartmannPatricio proveedor;

	@Column(name = "monto", precision = 10, scale = 2, nullable = false)
	private BigDecimal monto;

	@Column(name = "direccion_entrega", length = 255, nullable = false)
	private String direccionEntrega;

	@Column(name = "fecha_entrega", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaEntrega;

	@Column(name = "estado", length = 1)
	private String estado = "P";

	public String getEstadoDescripcion() {
		if (estado == null) {
			return "";
		}
		return switch (estado) {
			case "P" -> "Pendiente";
			case "C" -> "Completado";
			case "A" -> "Anulado";
			default -> estado;
		};
	}

}
