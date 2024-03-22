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

import com.RNE.referentiel.entities.CodePostal;
import com.RNE.referentiel.serviceInterface.codePostalService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/referentiel/codePostal")
@AllArgsConstructor
public class CodePostalController {
  
	private codePostalService codePostalService;
	
	@PostMapping
	public ResponseEntity<CodePostal> saveCodePostal(@RequestBody CodePostal codePostal){
		return new ResponseEntity<CodePostal>(codePostalService.saveCodePostal(codePostal),HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<CodePostal>> getAllCodesPostal(){
		return new ResponseEntity<List<CodePostal>>(codePostalService.getAllCodesPostal(),HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<CodePostal> getCodePostalById(@PathVariable Long id){
		return new ResponseEntity<CodePostal>(codePostalService.getCodePostalById(id), HttpStatus.OK);
		
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<CodePostal> updateCodePostal(@PathVariable Long id,@RequestBody CodePostal codePostal){
		return new ResponseEntity<CodePostal>(codePostalService.updateCodePostal(id, codePostal),HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteCodePostal(@PathVariable Long id){
		codePostalService.deleteCodePostal(id);
		return new  ResponseEntity<String>("codePostal successfully deleted!", HttpStatus.OK);
	}
}
