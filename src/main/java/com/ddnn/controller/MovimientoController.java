package com.ddnn.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ddnn.entity.Movimiento;
import com.ddnn.entity.OperacionDTO;
import com.ddnn.service.MovimientoService;
import com.ddnn.service.TipoCambioService;

import rx.Single;
import rx.schedulers.Schedulers;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/movimiento")
public class MovimientoController {

	@Autowired
	MovimientoService movimientoService;
	@Autowired
	TipoCambioService tipocambioService;

	@PostMapping
	private Single<ResponseEntity<OperacionDTO>> showMovimiento(@RequestBody Movimiento movimiento) {
		movimiento = movimientoService.calcular(movimiento);
		return movimientoService.save(movimiento).subscribeOn(Schedulers.io())
				.map(m -> ResponseEntity.created(URI.create("/api/v1/movimiento/")).body(m));
	}

	@GetMapping
	private Single<ResponseEntity<List<Movimiento>>> getAll() {
		return movimientoService.getAll().subscribeOn(Schedulers.io())
				.map(m -> ResponseEntity.ok(m));
	}

}
