package com.api.reserva.web.rest.request;

import java.time.LocalDate;
import java.util.Date;

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
public class ReservaRequest {

	@NotNull
	private String tomador;

	@NotNull
	private LocalDate desde;

	private LocalDate hasta;

	@NotNull
	private Long servicioId;
}
