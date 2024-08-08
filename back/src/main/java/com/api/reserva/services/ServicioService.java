package com.api.reserva.services;

import java.util.List;

import com.api.reserva.data.entity.ServicioEntity;
import com.api.reserva.services.exception.ServiceException;
import com.api.reserva.web.rest.request.ServicioRequest;

public interface ServicioService {

	ServicioEntity findById(Long id) throws ServiceException;

	List<ServicioEntity> findAll();

	ServicioEntity save(ServicioRequest request);

	ServicioEntity update(Long id, ServicioRequest request) throws ServiceException;

}
