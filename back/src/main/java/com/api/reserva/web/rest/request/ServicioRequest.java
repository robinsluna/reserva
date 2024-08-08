package com.api.reserva.web.rest.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ServicioRequest {

	@NotNull
	private String nombre;

	private String descripcion;

	@NotNull
	private Double precio;
}
