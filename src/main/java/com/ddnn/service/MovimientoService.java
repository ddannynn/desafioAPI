package com.ddnn.service;

import java.util.List;

import com.ddnn.entity.Movimiento;
import com.ddnn.entity.OperacionDTO;

import rx.Single;

public interface MovimientoService {
	public Single<List<Movimiento>> getAll();

	public Single<OperacionDTO> save(Movimiento movimiento);
	
	public Movimiento calcular(Movimiento movimiento);
}
