package com.RNE.referentiel.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RNE.referentiel.dto.CityDTO;
import com.RNE.referentiel.services.CityService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/referentiel/cities")
@AllArgsConstructor
public class CityController {

	private final CityService cityService;

	@PostMapping
	@PreAuthorize("hasRole('client_admin')")
	public ResponseEntity<CityDTO> saveCity(@RequestBody CityDTO cityDTO) {
		return new ResponseEntity<CityDTO>(cityService.saveCity(cityDTO), HttpStatus.CREATED);
	}

	@GetMapping
	@PreAuthorize("hasRole('client_user')")
	public ResponseEntity<List<CityDTO>> getAllCity() {
		return new ResponseEntity<List<CityDTO>>(cityService.getAllCity(), HttpStatus.OK);
	}

	// get city by code
	@GetMapping("/{code}")
	public ResponseEntity<CityDTO> getCityByCode(@PathVariable String code) {
		return new ResponseEntity<CityDTO>(cityService.getCityByCode(code), HttpStatus.OK);
	}

	// update city
	@PutMapping("/update/{code}")
	public ResponseEntity<CityDTO> updateCity(@PathVariable String code, @RequestBody CityDTO cityDTO) {
		return new ResponseEntity<CityDTO>(cityService.updateCity(code, cityDTO), HttpStatus.OK);
	}

	// getActivate city
	@GetMapping("/Activated")
	public ResponseEntity<List<CityDTO>> getActivatedCity() {
		return new ResponseEntity<List<CityDTO>>(cityService.getActivatedCity(), HttpStatus.OK);
	}

	@DeleteMapping("/{code}")
	public ResponseEntity<String> deleteCity(@PathVariable String code) {
		cityService.deleteCity(code);
		return new ResponseEntity<String>("City successfully deleted!", HttpStatus.OK);
	}

}