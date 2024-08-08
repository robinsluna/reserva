package com.api.reserva.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.reserva.data.entity.ReservaEntity;

import jakarta.transaction.Transactional;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaEntity, Long> {

	public ReservaEntity save(ReservaEntity entity);
}
