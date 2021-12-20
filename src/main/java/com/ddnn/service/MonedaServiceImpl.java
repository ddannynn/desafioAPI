package com.ddnn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddnn.entity.Moneda;
import com.ddnn.entity.Movimiento;
import com.ddnn.repository.MonedaRepository;

import rx.Single;
import rx.SingleSubscriber;

@Service
public class MonedaServiceImpl implements MonedaService {

	@Autowired
	MonedaRepository monedaRepository;

	@Override
	public Single<List<Moneda>> getAll() {
		return Single.create(singleSubscriber -> {
        	List<Moneda> mon = monedaRepository.findAll();
			singleSubscriber.onSuccess(mon);
        });
	}

	@Override
	public Moneda getById(int mon_id) {
		return monedaRepository.findById(mon_id).orElse(null);
	}

	@Override
	public Single<Moneda> save(Moneda moneda) {
		return Single.create(SingleSubscriber -> {
			monedaRepository.save(moneda);
			SingleSubscriber.onSuccess(moneda);
		});
	}

}
