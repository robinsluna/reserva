package com.api.reserva.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.reserva.data.entity.ReservaEntity;
import com.api.reserva.data.entity.ServicioEntity;
import com.api.reserva.data.repository.ReservaRepository;
import com.api.reserva.data.repository.ServicioRepository;
import com.api.reserva.services.ReservaService;
import com.api.reserva.services.exception.ServiceException;
import com.api.reserva.web.rest.request.ReservaRequest;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	private ServicioRepository servicioRepository;

	@Autowired
	private ReservaRepository reservaRepository;

	@Override
	public ReservaEntity findById(Long id) throws ServiceException {
		Optional<ReservaEntity> reserva = reservaRepository.findById(id);
		if (reserva.isEmpty()) {
			throw new ServiceException("No se encontro la reserva");
		}
		return reserva.get();
	}

	@Override
	public List<ReservaEntity> findAll() {
		return reservaRepository.findAll();
	}

	@Override
	public ReservaEntity save(ReservaRequest request) throws ServiceException {
		Optional<ServicioEntity> servicio = servicioRepository.findById(request.getServicioId());
		if (servicio.isEmpty()) {
			throw new ServiceException("No se encontro el servicio");
		}
		return reservaRepository.save(ReservaEntity.builder()
				.tomador(request.getTomador())
				.desde(request.getDesde())
				.hasta(request.getHasta())
				.servicio(servicio.get())
				.build());
	}

	@Override
	public ReservaEntity update(Long id, ReservaRequest request) throws ServiceException {
		Optional<ServicioEntity> servicio = servicioRepository.findById(request.getServicioId());
		if (servicio.isEmpty()) {
			throw new ServiceException("No se encontro el servicio");
		}
		if (reservaRepository.findById(id).isEmpty()) {
			throw new ServiceException("No se encontro la reserva");
		}
		
		return reservaRepository.save(ReservaEntity.builder()
				.id(id)
				.tomador(request.getTomador())
				.desde(request.getDesde())
				.hasta(request.getHasta())
				.servicio(servicio.get())
				.build());
	}

}
