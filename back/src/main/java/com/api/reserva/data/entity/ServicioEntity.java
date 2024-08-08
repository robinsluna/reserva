package com.api.reserva.data.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "servicios")
public class ServicioEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@SequenceGenerator(name = "servicios_generator", sequenceName = "servicios_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servicios_generator")
	private Long id;

	@Column(nullable = false)
	private String nombre;

	@Column()
	private String descripcion;

	@Column(nullable = false)
	private Double precio;

}
