package com.picoplaca.model;

public class Auto {
	 private int id;
	 private String placa;
	 private String color;
	 private String modelo;
	 private String chasis;
	 private String marca;
	public Auto(int id, String placa, String color, String modelo, String chasis, String marca) {
		super();
		this.id = id;
		this.placa = placa;
		this.color = color;
		this.modelo = modelo;
		this.chasis = chasis;
		this.marca = marca;
	}
	public Auto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getChasis() {
		return chasis;
	}
	public void setChasis(String chasis) {
		this.chasis = chasis;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	};
	
	 
}
