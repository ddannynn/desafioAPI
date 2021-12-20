package com.ddnn.entity;

import java.io.Serializable;

public class OperacionDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int mon_origen;
	private String mon_origen_des;
	private Double imp_origen;
	private int mon_destino;
	private String mon_destino_des;
	private Double imp_destino;
	private String cambio;
	private Double tipo_cambio;

	public int getMon_origen() {
		return mon_origen;
	}

	public void setMon_origen(int mon_origen) {
		this.mon_origen = mon_origen;
	}

	public String getMon_origen_des() {
		return mon_origen_des;
	}

	public void setMon_origen_des(String mon_origen_des) {
		this.mon_origen_des = mon_origen_des;
	}

	public Double getImp_origen() {
		return imp_origen;
	}

	public void setImp_origen(Double imp_origen) {
		this.imp_origen = imp_origen;
	}

	public int getMon_destino() {
		return mon_destino;
	}

	public void setMon_destino(int mon_destino) {
		this.mon_destino = mon_destino;
	}

	public String getMon_destino_des() {
		return mon_destino_des;
	}

	public void setMon_destino_des(String mon_destino_des) {
		this.mon_destino_des = mon_destino_des;
	}

	public Double getImp_destino() {
		return imp_destino;
	}

	public void setImp_destino(Double imp_destino) {
		this.imp_destino = imp_destino;
	}

	public String getCambio() {
		return cambio;
	}

	public Double getTipo_cambio() {
		return tipo_cambio;
	}

	public void setTipo_cambio(Double tipo_cambio) {
		this.tipo_cambio = tipo_cambio;
	}

	public void setCambio(String cambio) {
		this.cambio = cambio;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
