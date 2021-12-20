package com.ddnn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ddnn.entity.TipoCambio;

@Repository
public interface TipoCambioRepository extends JpaRepository<TipoCambio, Integer> {

	TipoCambio getByMonedaId(int mon_id);

	TipoCambio findFirstByMonedaIdOrderByFechaDesc(int mon_id);
}
