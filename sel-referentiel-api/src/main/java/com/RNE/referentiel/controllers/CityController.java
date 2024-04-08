package com.RNE.referentiel.controllers;

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
import com.RNE.referentiel.services.impl.CityService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/referentiel/cities")
@AllArgsConstructor
public class CityController {

	private CityService cityService;

	// save city controller
	@PostMapping
	public ResponseEntity<City> saveCity(@RequestBody City city) {
		return new ResponseEntity<City>(cityService.saveCity(city), HttpStatus.CREATED);
	}

	// get city controller
	@GetMapping
	public ResponseEntity<List<City>> getAllCities() {
		return new ResponseEntity<List<City>>(cityService.getAllCity(), HttpStatus.OK);
	}

	// get city by code controller
	@GetMapping("/{code}")
	public ResponseEntity<City> getCityByCode(@PathVariable String code) {
		return new ResponseEntity<City>(cityService.getCityByCode(code), HttpStatus.OK);
	}

	// update city controller
	@PutMapping("/update/{code}")
	public ResponseEntity<City> updateCity(@PathVariable String code, @RequestBody City city) {
		return new ResponseEntity<City>(cityService.updateCity(code, city), HttpStatus.OK);
	}

	// get Activated city controller
	@GetMapping("/activated")
	public ResponseEntity<List<City>> getActivatedCities() {
		return new ResponseEntity<>(cityService.getActivatedCity(), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{code}")
	public ResponseEntity<String> deleteCity(@PathVariable String code) {
		cityService.deleteCity(code);
		return new ResponseEntity<String>("City successfully deleted!", HttpStatus.OK);
	}
}
