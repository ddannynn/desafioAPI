package com.ddnn.service;

import java.util.List;

import com.ddnn.entity.Moneda;

import rx.Single;

public interface MonedaService {
	
	public Single<List<Moneda>> getAll();
	public Moneda getById(int mon_id);
	public Single<Moneda> save(Moneda moneda);

}
