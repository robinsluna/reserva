package com.api.reserva.services;

import java.util.List;

import com.api.reserva.data.entity.ReservaEntity;
import com.api.reserva.services.exception.ServiceException;
import com.api.reserva.web.rest.request.ReservaRequest;

public interface ReservaService {

	ReservaEntity findById(Long id) throws ServiceException;

	List<ReservaEntity> findAll();

	ReservaEntity save(ReservaRequest entity) throws ServiceException;

	ReservaEntity update(Long id, ReservaRequest entity) throws ServiceException;
}
