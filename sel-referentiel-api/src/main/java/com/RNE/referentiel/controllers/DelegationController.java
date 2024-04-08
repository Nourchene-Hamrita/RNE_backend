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

import com.RNE.referentiel.entities.Delegation;
import com.RNE.referentiel.services.DelegationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/referentiel/delegations")
@AllArgsConstructor
public class DelegationController {

	private final DelegationService delegationService;

	@PostMapping
	@PreAuthorize("hasRole('client_admin')")
	public ResponseEntity<Delegation> saveDelegation(@RequestBody Delegation del) {
		return new ResponseEntity<Delegation>(delegationService.saveDelegation(del), HttpStatus.CREATED);
	}

	@GetMapping
	@PreAuthorize("hasRole('client_user')")
	public ResponseEntity<List<Delegation>> getAllDelegations() {
		return new ResponseEntity<List<Delegation>>(delegationService.getAllDelegations(), HttpStatus.OK);
	}

	// get governorate by code
	@GetMapping("/{code}")
	public ResponseEntity<Delegation> getDelegationByCode(@PathVariable String code) {
		return new ResponseEntity<Delegation>(delegationService.getDelegationByCode(code), HttpStatus.OK);
	}

	// update governorate
	@PutMapping("/update/{code}")
	public ResponseEntity<Delegation> updateDelegation(@PathVariable String code, @RequestBody Delegation del) {
		return new ResponseEntity<Delegation>(delegationService.updateDelegation(code, del), HttpStatus.OK);
	}

	// getActivate governorate
	@GetMapping("/Activated")
	public ResponseEntity<List<Delegation>> getActivatedDelegation() {
		return new ResponseEntity<List<Delegation>>(delegationService.getActivatedDelegation(), HttpStatus.OK);
	}

	@DeleteMapping("/{code}")
	public ResponseEntity<String> deleteDelegation(@PathVariable String code) {
		delegationService.deleteDelegation(code);
		return new ResponseEntity<String>("Delegation successfully deleted!", HttpStatus.OK);
	}

}
