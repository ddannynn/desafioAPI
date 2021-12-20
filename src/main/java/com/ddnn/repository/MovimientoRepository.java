package com.ddnn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ddnn.entity.Movimiento;

@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {

}
