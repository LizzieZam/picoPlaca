package com.picoplaca.service;

import java.util.Date;
import java.util.List;

import com.picoplaca.model.Auto;
import com.picoplaca.model.Consulta;

public interface AutoService {
	public List<Auto> getAllAutos();
	 
	 public String getCosulta(String placa,Date fecha,Date hora);
	 
	
	 public Auto getAutoById(int id) ;
	 public Auto addAuto(Auto auto);
	 	
}
