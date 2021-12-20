package com.ddnn.service;

import java.util.List;

import com.ddnn.entity.TipoCambio;

import rx.Single;

public interface TipoCambioService {

	public Single<List<TipoCambio>> getAll();

	public void save(TipoCambio tipoCambio);
	
	public TipoCambio getByMonedaId(int mon_id);
	
	public TipoCambio getFirstByMonedaIdOrderByFecha(int mon_id);
	
	public TipoCambio doUpdate(TipoCambio tipocambio);
	
	public Single<TipoCambio> getById(int tc_id);
}
