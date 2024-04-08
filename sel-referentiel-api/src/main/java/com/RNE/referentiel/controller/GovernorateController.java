package com.RNE.referentiel.controller;

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

import com.RNE.referentiel.entities.Governorate;

import com.RNE.referentiel.serviceInterface.GovernorateService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/referentiel/governorates")
@AllArgsConstructor
public class GovernorateController {

	private final GovernorateService gouverneratService;

	@PostMapping
	@PreAuthorize("hasRole('client_admin')")
	public ResponseEntity<Governorate> saveGouvernerat(@RequestBody Governorate gouvernerat) {
		return new ResponseEntity<Governorate>(gouverneratService.saveGovernorate(gouvernerat), HttpStatus.CREATED);
	}

	@GetMapping
	@PreAuthorize("hasRole('client_user')")
	public ResponseEntity<List<Governorate>> getAllGouvernerat() {
		return new ResponseEntity<List<Governorate>>(gouverneratService.getAllGovernorates(), HttpStatus.OK);
	}

	// get governorate by code
	@GetMapping("/{govCode}")
	public ResponseEntity<Governorate> getGouverneratByCode(@PathVariable String govCode) {
		return new ResponseEntity<Governorate>(gouverneratService.getGovernorateByCode(govCode), HttpStatus.OK);
	}

	// update governorate
	@PutMapping("/update/{govCode}")
	public ResponseEntity<Governorate> updateGouvernerat(@PathVariable String govCode, @RequestBody Governorate gouv) {
		return new ResponseEntity<Governorate>(gouverneratService.updateGovernorate(govCode, gouv), HttpStatus.OK);
	}

	// getActivate governorate
	@GetMapping("/Activated")
	public ResponseEntity<List<Governorate>> getActivatedGouvernerat() {
		return new ResponseEntity<List<Governorate>>(gouverneratService.getActivatedGovernorate(), HttpStatus.OK);
	}

	@DeleteMapping("/{govCode}")
	public ResponseEntity<String> deleteGouvernerat(@PathVariable String govCode) {
		gouverneratService.deleteGovernorate(govCode);
		return new ResponseEntity<String>("Governorat successfully deleted!", HttpStatus.OK);
	}

}
