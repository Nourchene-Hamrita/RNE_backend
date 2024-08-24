package com.RNE.referentiel.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.RNE.referentiel.dto.FormeJuridiqueDto;
import com.RNE.referentiel.dto.GouvernoratDTO;
import com.RNE.referentiel.services.FormeJuridiqueService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/referentiel/FormeJuridique")
@CrossOrigin("*")
@AllArgsConstructor
public class FormeJuridiqueController {

	private FormeJuridiqueService formeJuridiqueService;

	@PostMapping
	public ResponseEntity<FormeJuridiqueDto> saveFormeJuridique(@RequestBody FormeJuridiqueDto formeJuridiquedto) {
		return new ResponseEntity<FormeJuridiqueDto>(formeJuridiqueService.saveFormeJuridique(formeJuridiquedto),
				HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<FormeJuridiqueDto>> getAllFormeJuridique() {
		return new ResponseEntity<List<FormeJuridiqueDto>>(formeJuridiqueService.getAllFormeJuridique(), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<FormeJuridiqueDto> updateFormeJuridiqe(@PathVariable Long id,
			@RequestBody FormeJuridiqueDto formeJuridiquedto) {
		return new ResponseEntity<FormeJuridiqueDto>(formeJuridiqueService.updateFormeJuridique(id, formeJuridiquedto),
				HttpStatus.OK);
	}
	
	//pagination method
	
		@GetMapping("/pagination/{pageNumber}/{pageSize}")
		public Page<FormeJuridiqueDto> gouvernoratPagination(@PathVariable int pageNumber,@PathVariable int pageSize){
			return formeJuridiqueService.getFormeJuridiquePagination(pageNumber,pageSize);
		}
}
