package com.ddnn.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ddnn.entity.Moneda;
import com.ddnn.service.MonedaService;

import rx.Single;
import rx.schedulers.Schedulers;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/moneda")
public class MonedaController {

	@Autowired
	MonedaService monedaService;

	@GetMapping
	private Single<ResponseEntity<List<Moneda>>> getAllMoneda() {
		return monedaService.getAll().subscribeOn(Schedulers.io())
				.map(m -> ResponseEntity.ok(m));
	}

	@PostMapping
	private Single<ResponseEntity<Moneda>> saveMoneda(@RequestBody Moneda moneda) {
		return monedaService.save(moneda).subscribeOn(Schedulers.io())
				.map(m -> ResponseEntity.created(URI.create("/api/v1/moneda/")).body(m));
	}

}
