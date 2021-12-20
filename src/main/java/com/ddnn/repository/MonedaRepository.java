package com.ddnn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ddnn.entity.Moneda;

@Repository
public interface MonedaRepository extends JpaRepository<Moneda, Integer> {

}
