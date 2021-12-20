package com.ddnn.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "tipo_cambio")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TipoCambio implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tc_id")
	private int id;
	@Column(name = "tc_fecha")
	private Date fecha;
	@Column(name = "tc_compra")
	private Double compra;
	@Column(name = "tc_venta")
	private Double venta;

	@OneToOne
	@JoinColumn(name = "mon_id")
	private Moneda moneda;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getCompra() {
		return compra;
	}

	public void setCompra(Double compra) {
		this.compra = compra;
	}

	public Double getVenta() {
		return venta;
	}

	public void setVenta(Double venta) {
		this.venta = venta;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
