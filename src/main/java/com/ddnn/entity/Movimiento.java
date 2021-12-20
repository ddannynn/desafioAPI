package com.ddnn.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "movimiento")
public class Movimiento implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mov_id")
	private int id;
	@Column(name = "mov_mon_id_origen")
	private int moneda_o;
	@Column(name = "mov_importe_origen")
	private Double importe_o;
	@Column(name = "mov_mon_id_destino")
	private int moneda_d;
	@Column(name = "mov_importe_destino")
	private Double importe_d;
	@Column(name = "mov_cambio")
	private String cambio;
	@OneToOne
	@JoinColumn(name = "tc_id")
	private TipoCambio tipocambio;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMoneda_o() {
		return moneda_o;
	}

	public void setMoneda_o(int moneda_o) {
		this.moneda_o = moneda_o;
	}

	public Double getImporte_o() {
		return importe_o;
	}

	public void setImporte_o(Double importe_o) {
		this.importe_o = importe_o;
	}

	public int getMoneda_d() {
		return moneda_d;
	}

	public void setMoneda_d(int moneda_d) {
		this.moneda_d = moneda_d;
	}

	public Double getImporte_d() {
		return importe_d;
	}

	public void setImporte_d(Double importe_d) {
		this.importe_d = importe_d;
	}

	public String getCambio() {
		return cambio;
	}

	public void setCambio(String cambio) {
		this.cambio = cambio;
	}

	public TipoCambio getTipocambio() {
		return tipocambio;
	}

	public void setTipocambio(TipoCambio tipocambio) {
		this.tipocambio = tipocambio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
