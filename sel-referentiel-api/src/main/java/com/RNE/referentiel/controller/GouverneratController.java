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

import com.RNE.referentiel.entities.Gouvernerat;
import com.RNE.referentiel.service.GouverneratServiceImpl;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/v1/referentiel/gouvernerats")
@AllArgsConstructor
public class GouverneratController {
  
	
	private final GouverneratServiceImpl gouverneratService;
	
	
	@PostMapping
	public ResponseEntity<Gouvernerat>saveGouvernerat(@RequestBody Gouvernerat gouvernerat){
		return new ResponseEntity<Gouvernerat>(gouverneratService.saveGouvernerat(gouvernerat),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Gouvernerat>>getAllGouvernerat(){
		return new ResponseEntity<List<Gouvernerat>>(gouverneratService.getAllGouvernerats(),HttpStatus.OK);
	}
	//get gouv by code
	@GetMapping("/{codeGouv}")
	public ResponseEntity<Gouvernerat> getGouverneratByCode(@PathVariable String codeGouv){
		return new ResponseEntity<Gouvernerat>(gouverneratService.getGouverneratByCode(codeGouv),HttpStatus.OK);
	}
	//update Gouvernerat
	@PutMapping("/{codeGouv}")
	public ResponseEntity<Gouvernerat> updateGouvernerat(@PathVariable String codeGouv,@RequestBody Gouvernerat gouv){
		return new ResponseEntity<Gouvernerat>(gouverneratService.updateGouvernerat(codeGouv, gouv),HttpStatus.OK);
	}
	
	//getActivate Gouvernerat
	@GetMapping("/Activated")
	public ResponseEntity<List<Gouvernerat>> getActivatedGouvernerat(){
		return new ResponseEntity<List<Gouvernerat>>(gouverneratService.getActivatedGouvernerat(),HttpStatus.OK);
	}
	@DeleteMapping("/{code_gouv}")
	public ResponseEntity<String> deleteGouvernerat(@PathVariable String code_gouv){
	  gouverneratService.deleteGouvernerat(code_gouv);
	  return new  ResponseEntity<String>("Gouvernerat successfully deleted!", HttpStatus.OK);
	}
	
}
