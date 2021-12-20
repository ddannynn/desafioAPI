package com.ddnn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ddnn.entity.TipoCambio;
import com.ddnn.service.TipoCambioService;

import rx.Single;
import rx.schedulers.Schedulers;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/tipocambio")
public class TipoCambioController {

	@Autowired
	TipoCambioService tipocambioService;

	@GetMapping
	private Single<ResponseEntity<List<TipoCambio>>> getAllTipoCambio() {
		return tipocambioService.getAll().subscribeOn(Schedulers.io())
				.map(m -> ResponseEntity.ok(m));
	}
	
	@GetMapping("/{tc_id}")
	private Single<ResponseEntity<TipoCambio>> getById(@PathVariable("tc_id") int tc_id) {
		return tipocambioService.getById(tc_id).subscribeOn(Schedulers.io())
				.map(m -> ResponseEntity.ok(m));
	}

	@PostMapping
	private ResponseEntity<TipoCambio> saveTipoCambio(@RequestBody TipoCambio tipocambio) {
		tipocambioService.save(tipocambio);
		return new ResponseEntity<TipoCambio>(HttpStatus.CREATED);
	}
	
	@PostMapping("/update")
	private ResponseEntity<TipoCambio> updateTipoCambio(@RequestBody TipoCambio tipocambio) {
		tipocambioService.save(tipocambioService.doUpdate(tipocambio));
		return new ResponseEntity<TipoCambio>(HttpStatus.CREATED);
	}

}
