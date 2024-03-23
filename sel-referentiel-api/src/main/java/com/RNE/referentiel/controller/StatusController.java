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
@RequestMapping("/api/referentiel/status")
@AllArgsConstructor
public class StatusController {
  
	private StatusService statusService;
	
	@PostMapping
	public ResponseEntity<Status> saveStatut(@RequestBody Status statut){
		return new ResponseEntity<Status>(statusService.saveStatut(statut),HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<Status>> getAllStatut(){
		return new ResponseEntity<List<Status>>(statusService.getAllStatut(),HttpStatus.OK);
	}
	
	@GetMapping("/{statusCode}")
	public ResponseEntity<Status> getStatutByCode(@PathVariable String statusCode){
		return new ResponseEntity<Status>(statusService.getStatutByCode(statusCode), HttpStatus.OK);
		
	}
	
	@PutMapping("/update/{statusCode}")
	public ResponseEntity<Status> updateStatut(@PathVariable String statusCode ,@RequestBody Status statut){
		return new ResponseEntity<Status>(statusService.updateStatut(statusCode, statut),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{statusCode}")
	public ResponseEntity<String> deleteCodePostal(@PathVariable String statusCode){
		statusService.deleteStatut(statusCode);
		return new  ResponseEntity<String>("Status successfully deleted!", HttpStatus.OK);
	}
}
