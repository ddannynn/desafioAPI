package com.ddnn.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddnn.entity.Moneda;
import com.ddnn.entity.TipoCambio;
import com.ddnn.repository.TipoCambioRepository;

import rx.Single;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {

	@Autowired
	TipoCambioRepository tipocambioRepository;

	@Override
	public Single<List<TipoCambio>> getAll() {
		return Single.create(singleSubscriber -> {
        	List<TipoCambio> tc = tipocambioRepository.findAll();
			singleSubscriber.onSuccess(tc);
        });
	}
	
	@Override
	public void save(TipoCambio tipoCambio) {
		tipocambioRepository.save(tipoCambio);
	}

	@Override
	public TipoCambio getByMonedaId(int mon_id) {
		return tipocambioRepository.getByMonedaId(mon_id);
	}

	@Override
	public TipoCambio getFirstByMonedaIdOrderByFecha(int mon_id) {
		return tipocambioRepository.findFirstByMonedaIdOrderByFechaDesc(mon_id);
	}

	@Override
	public TipoCambio doUpdate(TipoCambio tipocambio) {
		Single<TipoCambio> stc = getById(tipocambio.getId());
		TipoCambio tc = new TipoCambio();
		BeanUtils.copyProperties(stc, tc);
		tc.setCompra(tipocambio.getCompra());
		tc.setVenta(tipocambio.getVenta());
		return tc;
	}

	@Override
	public Single<TipoCambio> getById(int tc_id) {
		return Single.create(singleSubscriber -> {
        	TipoCambio tc = tipocambioRepository.getById(tc_id);
			singleSubscriber.onSuccess(tc);
        });
	}

}
