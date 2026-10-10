package com.examenT2.LP2_T2_Hartmann_Patricio.model;

import java.time.LocalDateTime;

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
@Table(name = "tbl_proveedor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProveedorHartmannPatricio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_proveedor")
	private Integer idProveedor;

	@Column(name = "ruc", length = 11, nullable = false)
	private String ruc;

	@Column(name = "razon_social", length = 50, nullable = false, unique = true)
	private String razonSocial;

	@Column(name = "fecha_registro", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime fechaRegistro;

	@Column(name = "direccion", length = 100, nullable = false)
	private String direccion;

	@Column(name = "pagina_web", length = 100)
	private String paginaWeb;

	@ManyToOne
	@JoinColumn(name = "id_rubro")
	private RubroHartmannPatricio rubro;

	public String getRucYRazonSocial() {
		return ruc + " - " + razonSocial;
	}

}
