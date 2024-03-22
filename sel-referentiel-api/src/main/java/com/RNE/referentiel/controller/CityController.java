package com.RNE.referentiel.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RNE.referentiel.entities.City;
import com.RNE.referentiel.serviceInterface.CityService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/referentiel/villes")
@AllArgsConstructor
public class CityController {
 
	private CityService cityService;
	
	//save ville controller
	@PostMapping
	public ResponseEntity<City> saveCity(@RequestBody City city){
		return new ResponseEntity<City>(cityService.saveCity(city),HttpStatus.CREATED);
	}
	// get villes controller
	@GetMapping
	public ResponseEntity<List<City>> getAllCities(){
		return new ResponseEntity<List<City>>(cityService.getAllCity(),HttpStatus.OK);
	}
	
	//get villes by code controller
	@GetMapping("/{codeCity}")
	public ResponseEntity<City>getCityByCode(@PathVariable String cityCode){
		return new ResponseEntity<City>(cityService.getCityByCode(cityCode),HttpStatus.OK);
	}
	
	//update ville controller
	@PutMapping("/update/{codeCity}")
	public ResponseEntity<City>updateCity(@PathVariable String cityCode,@RequestBody City city){
		return new ResponseEntity<City>(cityService.updateCity(cityCode, city),HttpStatus.OK);
	}
	
	//get Activated ville controller
	@GetMapping("/activated")
	public ResponseEntity<List<City>> getActivatedCities(){
		return new ResponseEntity<>(cityService.getActivatedCity(),HttpStatus.OK);
	}
	@DeleteMapping("/{codeCity}")
	public ResponseEntity<String> deleteCity(@PathVariable String cityCode){
	  cityService.deleteCity(cityCode);
	  return new  ResponseEntity<String>("City successfully deleted!", HttpStatus.OK);
	}
}
