package com.api.reserva.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.reserva.data.entity.ServicioEntity;

import jakarta.transaction.Transactional;

@Repository
public interface ServicioRepository extends JpaRepository<ServicioEntity, Long> {

	public ServicioEntity save(ServicioEntity entity);
}
