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

import com.RNE.referentiel.entities.Ville;
import com.RNE.referentiel.serviceInterface.VilleService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/referentiel/villes")
@AllArgsConstructor
public class VilleController {
 
	private VilleService villeService;
	
	//save ville controller
	@PostMapping
	public ResponseEntity<Ville> saveVille(@RequestBody Ville ville){
		return new ResponseEntity<Ville>(villeService.saveVille(ville),HttpStatus.CREATED);
	}
	// get villes controller
	@GetMapping
	public ResponseEntity<List<Ville>> getAllVilles(){
		return new ResponseEntity<List<Ville>>(villeService.getAllVille(),HttpStatus.OK);
	}
	
	//get villes by code controller
	@GetMapping("/{codeVille}")
	public ResponseEntity<Ville>getVilleByCode(@PathVariable String codeVille){
		return new ResponseEntity<Ville>(villeService.getVilleByCode(codeVille),HttpStatus.OK);
	}
	
	//update ville controller
	@PutMapping("/update/{codeVille}")
	public ResponseEntity<Ville>updateVille(@PathVariable String codeVille,@RequestBody Ville ville){
		return new ResponseEntity<Ville>(villeService.updateVille(codeVille, ville),HttpStatus.OK);
	}
	
	//get Activated ville controller
	@GetMapping("/activated")
	public ResponseEntity<List<Ville>> getActivatedVilles(){
		return new ResponseEntity<>(villeService.getActivatedVille(),HttpStatus.OK);
	}
	@DeleteMapping("/{codeVille}")
	public ResponseEntity<String> deleteVille(@PathVariable String codeVille){
	  villeService.deleteVille(codeVille);
	  return new  ResponseEntity<String>("Ville successfully deleted!", HttpStatus.OK);
	}
}
