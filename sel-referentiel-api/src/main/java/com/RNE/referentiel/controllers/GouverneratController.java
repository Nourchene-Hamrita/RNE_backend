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

import com.RNE.referentiel.dto.GouverneratDTO;
import com.RNE.referentiel.services.GouverneratService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/referentiel/gouvernerats")
@AllArgsConstructor
public class GouverneratController {

	private final GouverneratService gouverneratService;

	@PostMapping
	@PreAuthorize("hasRole('client_admin')")
	public ResponseEntity<GouverneratDTO> saveDelegation(@RequestBody GouverneratDTO gouverneratDTO) {
		return new ResponseEntity<GouverneratDTO>(gouverneratService.saveGouvernerat(gouverneratDTO), HttpStatus.CREATED);
	}

	@GetMapping
	@PreAuthorize("hasRole('client_user')")
	public ResponseEntity<List<GouverneratDTO>> getAllDelegations() {
		return new ResponseEntity<List<GouverneratDTO>>(gouverneratService.getAllGouvernerats(), HttpStatus.OK);
	}

	// get delegation by code
	@GetMapping("/{code}")
	public ResponseEntity<GouverneratDTO> getDelegationByCode(@PathVariable String code) {
		return new ResponseEntity<GouverneratDTO>(gouverneratService.getGouverneratByCode(code), HttpStatus.OK);
	}

	// update delegation
	@PutMapping("/update/{code}")
	public ResponseEntity<GouverneratDTO> updateDelegation(@PathVariable String code,
			@RequestBody GouverneratDTO gouverneratDTO) {
		return new ResponseEntity<GouverneratDTO>(gouverneratService.updateGouvernerat(code, gouverneratDTO),
				HttpStatus.OK);
	}

	// getActivate delegation
	@GetMapping("/Activated")
	public ResponseEntity<List<GouverneratDTO>> getActivatedDelegations() {
		return new ResponseEntity<List<GouverneratDTO>>(gouverneratService.getActivatedGouvernerats(), HttpStatus.OK);
	}

	@DeleteMapping("/{code}")
	public ResponseEntity<String> deleteDelegation(@PathVariable String code) {
		gouverneratService.deleteGouvernerat(code);
		return new ResponseEntity<String>("Gouvernerat successfully deleted!", HttpStatus.OK);
	}

}