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

import com.RNE.referentiel.dto.DelegationDTO;
import com.RNE.referentiel.services.DelegationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/referentiel/delegations")
@AllArgsConstructor
public class DelegationController {

	private final DelegationService delegationService;

	@PostMapping
	@PreAuthorize("hasRole('client_admin')")
	public ResponseEntity<DelegationDTO> saveDelegation(@RequestBody DelegationDTO delegationDTO) {
		return new ResponseEntity<DelegationDTO>(delegationService.saveDelegation(delegationDTO), HttpStatus.CREATED);
	}

	@GetMapping
	@PreAuthorize("hasRole('client_user')")
	public ResponseEntity<List<DelegationDTO>> getAllDelegations() {
		return new ResponseEntity<List<DelegationDTO>>(delegationService.getAllDelegations(), HttpStatus.OK);
	}

	// get delegation by code
	@GetMapping("/{code}")
	public ResponseEntity<DelegationDTO> getDelegationByCode(@PathVariable String code) {
		return new ResponseEntity<DelegationDTO>(delegationService.getDelegationByCode(code), HttpStatus.OK);
	}

	// update delegation
	@PutMapping("/update/{code}")
	public ResponseEntity<DelegationDTO> updateDelegation(@PathVariable String code,
			@RequestBody DelegationDTO delegationDTO) {
		return new ResponseEntity<DelegationDTO>(delegationService.updateDelegation(code, delegationDTO),
				HttpStatus.OK);
	}

	// getActivate delegation
	@GetMapping("/Activated")
	public ResponseEntity<List<DelegationDTO>> getActivatedDelegations() {
		return new ResponseEntity<List<DelegationDTO>>(delegationService.getActivatedDelegations(), HttpStatus.OK);
	}

	@DeleteMapping("/{code}")
	public ResponseEntity<String> deleteDelegation(@PathVariable String code) {
		delegationService.deleteDelegation(code);
		return new ResponseEntity<String>("Delegation successfully deleted!", HttpStatus.OK);
	}

}