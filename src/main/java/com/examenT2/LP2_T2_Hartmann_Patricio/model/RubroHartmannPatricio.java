package com.examenT2.LP2_T2_Hartmann_Patricio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_rubro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RubroHartmannPatricio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rubro")
	private Integer idRubro;

	@Column(name = "denominacion", length = 50, nullable = false)
	private String denominacion;

}
