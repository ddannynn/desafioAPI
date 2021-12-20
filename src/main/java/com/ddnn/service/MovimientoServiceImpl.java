package com.ddnn.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddnn.entity.Movimiento;
import com.ddnn.entity.OperacionDTO;
import com.ddnn.entity.TipoCambio;
import com.ddnn.repository.MovimientoRepository;

import rx.Single;
import rx.SingleSubscriber;

@Service
public class MovimientoServiceImpl implements MovimientoService {

	@Autowired
	MovimientoRepository movimientoRepository;

	@Autowired
	TipoCambioService tipocambioService;

	@Autowired
	MonedaService monedaService;

	@Override
	public Single<List<Movimiento>> getAll() {
		return findAll() 
			.map(this::movimientoResponseList);
	}

    private Single<List<Movimiento>> findAll() {
        return Single.create(singleSubscriber -> {
        	List<Movimiento> mov = movimientoRepository.findAll();
			singleSubscriber.onSuccess(mov);
        });
    }

    private List<Movimiento> movimientoResponseList(List<Movimiento> movimientoList) {
        return movimientoList
                .stream()
                .map(this::movimientoResponse)
                .collect(Collectors.toList());
    }

    private Movimiento movimientoResponse(Movimiento movimiento) {
        Movimiento mov = new Movimiento();
        BeanUtils.copyProperties(movimiento, mov);
        mov.setMoneda_o(movimiento.getMoneda_o());
        mov.setImporte_o(movimiento.getImporte_o());
        mov.setMoneda_d(movimiento.getMoneda_d());
        mov.setImporte_d(movimiento.getImporte_d());
        mov.setCambio(movimiento.getCambio());
        mov.setTipocambio(movimiento.getTipocambio());
        return mov;
    }

	@Override
	public Single<OperacionDTO> save(Movimiento movimiento) {
		return Single.create(singleSubscriber -> {
        	movimientoRepository.save(movimiento);
    		OperacionDTO ope = new OperacionDTO();
    		ope.setMon_origen(movimiento.getMoneda_o());
    		ope.setMon_origen_des(monedaService.getById(movimiento.getMoneda_o()).getNombre());
    		ope.setImp_origen(movimiento.getImporte_o());
    		ope.setMon_destino(movimiento.getMoneda_d());
    		ope.setMon_destino_des(monedaService.getById(movimiento.getMoneda_d()).getNombre());
    		ope.setImp_destino(movimiento.getImporte_d());
    		ope.setTipo_cambio(movimiento.getMoneda_o() > 1 ? movimiento.getTipocambio().getCompra()
    				: movimiento.getTipocambio().getVenta());
    		ope.setCambio(movimiento.getCambio());
            singleSubscriber.onSuccess(ope);
        });
	}
	

	@Override
	public Movimiento calcular(Movimiento movimiento) {
		int mon_cambio = (movimiento.getMoneda_o() > 1) ? movimiento.getMoneda_o() : movimiento.getMoneda_d();
		TipoCambio tc = new TipoCambio();
		tc = tipocambioService.getFirstByMonedaIdOrderByFecha(mon_cambio);
		Double d = (movimiento.getMoneda_o() > 1) ? movimiento.getImporte_o() * tc.getCompra()
				: movimiento.getImporte_o() / tc.getVenta();
		Double result = Math.round(d * 100.0) / 100.0;
//		Double result = (movimiento.getMoneda_o() > 1)
//				? Math.round(movimiento.getImporte_o() * tc.getCompra() * 100.0) / 100.0
//				: movimiento.getImporte_o() * tc.getVenta();

		movimiento.setMoneda_o(movimiento.getMoneda_o());
		movimiento.setImporte_o(movimiento.getImporte_o());
		movimiento.setMoneda_d(movimiento.getMoneda_d());
		movimiento.setImporte_d(result);
		movimiento.setCambio((movimiento.getMoneda_o() > 1) ? "Compra" : "Venta");
		movimiento.setTipocambio(tc);

		return movimiento;
	}

}
