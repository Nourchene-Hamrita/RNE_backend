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

import com.RNE.referentiel.entities.Statut;
import com.RNE.referentiel.serviceInterface.StatutService;


import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/referentiel/statuts")
@AllArgsConstructor
public class StatusController {
  
	private StatutService statutService;
	
	@PostMapping
	public ResponseEntity<Statut> saveStatut(@RequestBody Statut statut){
		return new ResponseEntity<Statut>(statutService.saveStatut(statut),HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<Statut>> getAllStatut(){
		return new ResponseEntity<List<Statut>>(statutService.getAllStatut(),HttpStatus.OK);
	}
	
	@GetMapping("{codeStatut}")
	public ResponseEntity<Statut> getStatutByCode(@PathVariable String codeStatut){
		return new ResponseEntity<Statut>(statutService.getStatutByCode(codeStatut), HttpStatus.OK);
		
	}
	
	@PutMapping("update/{codeStatut}")
	public ResponseEntity<Statut> updateStatut(@PathVariable String codeStatut ,@RequestBody Statut statut){
		return new ResponseEntity<Statut>(statutService.updateStatut(codeStatut, statut),HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{codeStatut}")
	public ResponseEntity<String> deleteCodePostal(@PathVariable String codeStatut){
		statutService.deleteStatut(codeStatut);
		return new  ResponseEntity<String>("Statut successfully deleted!", HttpStatus.OK);
	}
}
