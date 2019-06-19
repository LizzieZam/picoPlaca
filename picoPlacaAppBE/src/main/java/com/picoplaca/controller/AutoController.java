package com.picoplaca.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.picoplaca.model.Auto;
import com.picoplaca.service.AutoServiceImpl;

@RestController
public class AutoController {
@Autowired
private AutoServiceImpl autoService;
@GetMapping("/auto/")
public List<Auto> getAllAutos(){
	  return autoService.getAllAutos();
	 }
@GetMapping("/auto/{placa}/{fecha}/{hora}/")
public String  getCosulta(@PathVariable String placa,@PathVariable Date fecha,@PathVariable Date hora) {
	
	  return autoService.getCosulta(placa,fecha,hora);
	 }
@GetMapping("/auto/{autoId}")
public Auto getCustomerById(@PathVariable int auto) {
 return autoService.getAutoById(auto);
}
	 

@PostMapping("/auto/")
public ResponseEntity<Void> addCustomer(@RequestBody Auto auto, UriComponentsBuilder builder){
	Auto autor = autoService.addAuto(auto);
	  
	  if(autor == null) {
	   return ResponseEntity.noContent().build();
	  }
	  
	  HttpHeaders headers = new HttpHeaders();
	  headers.setLocation(builder.path("/auto/{id}").buildAndExpand(auto.getId()).toUri());
	  return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
	

	
}
