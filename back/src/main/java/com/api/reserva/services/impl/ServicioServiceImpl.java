package com.api.reserva.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.reserva.data.entity.ServicioEntity;
import com.api.reserva.data.repository.ServicioRepository;
import com.api.reserva.services.ServicioService;
import com.api.reserva.services.exception.ServiceException;
import com.api.reserva.web.rest.request.ServicioRequest;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ServicioServiceImpl implements ServicioService {

	@Autowired
	private ServicioRepository repository;

	@Override
	public ServicioEntity findById(Long id) throws ServiceException {
		Optional<ServicioEntity> servicio = repository.findById(id);
		if (servicio.isEmpty()) {
			throw new ServiceException("No se encontro la servicio");
		}
		return servicio.get();
	}

	@Override
	public List<ServicioEntity> findAll() {
		return repository.findAll();
	}

	@Override
	public ServicioEntity save(ServicioRequest request) {
		return repository.save(ServicioEntity.builder()
				.nombre(request.getNombre())
				.descripcion(request.getDescripcion())
				.precio(request.getPrecio())
				.build());
	}

	@Override
	public ServicioEntity update(Long id, ServicioRequest request) throws ServiceException {

		if (repository.findById(id).isEmpty()) {
			throw new ServiceException("No se encontro el servicio");
		}
		return repository.save(ServicioEntity.builder()
				.id(id)
				.nombre(request.getNombre())
				.descripcion(request.getDescripcion())
				.precio(request.getPrecio())
				.build());
	}

}
