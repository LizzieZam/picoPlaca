package com.picoplaca.model;

import java.util.Date;

public class Dias {
	private int nDia;	
	private String dia;
	private Date hora1;
	private Date hora11;
	private Date hora2;
	private Date hora21;
	private int placa;
	public Dias(int nDia,String dia, Date hora1, Date hora11, Date hora2, Date hora21,int placa) {
		super();
		this.nDia = nDia;
		this.dia = dia;
		this.hora1 = hora1;
		this.hora11 = hora11;
		this.hora2 = hora2;
		this.hora21 = hora21;
		this.placa=placa;
	}

	public int getPlaca() {
		return placa;
	}

	public void setPlaca(int placa) {
		this.placa = placa;
	}

	public int getnDia() {
		return nDia;
	}

	public void setnDia(int nDia) {
		this.nDia = nDia;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Date getHora1() {
		return hora1;
	}

	public void setHora1(Date hora1) {
		this.hora1 = hora1;
	}

	public Date getHora11() {
		return hora11;
	}

	public void setHora11(Date hora11) {
		this.hora11 = hora11;
	}

	public Date getHora2() {
		return hora2;
	}

	public void setHora2(Date hora2) {
		this.hora2 = hora2;
	}

	public Date getHora21() {
		return hora21;
	}

	public void setHora21(Date hora21) {
		this.hora21 = hora21;
	}

}
