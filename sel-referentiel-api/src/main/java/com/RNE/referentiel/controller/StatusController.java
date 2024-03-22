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

import com.RNE.referentiel.entities.Status;
import com.RNE.referentiel.serviceInterface.StatusService;


import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/referentiel/statuts")
@AllArgsConstructor
public class StatusController {
  
	private StatusService statutService;
	
	@PostMapping
	public ResponseEntity<Status> saveStatut(@RequestBody Status statut){
		return new ResponseEntity<Status>(statutService.saveStatut(statut),HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<Status>> getAllStatut(){
		return new ResponseEntity<List<Status>>(statutService.getAllStatut(),HttpStatus.OK);
	}
	
	@GetMapping("{codeStatut}")
	public ResponseEntity<Status> getStatutByCode(@PathVariable String statusCode){
		return new ResponseEntity<Status>(statutService.getStatutByCode(statusCode), HttpStatus.OK);
		
	}
	
	@PutMapping("update/{codeStatut}")
	public ResponseEntity<Status> updateStatut(@PathVariable String statusCode ,@RequestBody Status statut){
		return new ResponseEntity<Status>(statutService.updateStatut(statusCode, statut),HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{codeStatut}")
	public ResponseEntity<String> deleteCodePostal(@PathVariable String statusCode){
		statutService.deleteStatut(statusCode);
		return new  ResponseEntity<String>("Status successfully deleted!", HttpStatus.OK);
	}
}
