package com.api.reserva.web.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.reserva.services.ServicioService;
import com.api.reserva.services.exception.ServiceException;
import com.api.reserva.web.rest.request.ServicioRequest;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

	@Autowired
	private ServicioService service;

	@GetMapping()
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok(service.findAll());

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) throws ServiceException {
		return ResponseEntity.ok(service.findById(id));

	}

	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody ServicioRequest request) {
		return ResponseEntity.ok(service.save(request));

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody ServicioRequest request) throws ServiceException {
		return ResponseEntity.ok(service.update(id, request));

	}
}
