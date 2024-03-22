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

import com.RNE.referentiel.entities.Governorate;

import com.RNE.referentiel.serviceInterface.GovernorateService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/v1/referentiel/gouvernerats")
@AllArgsConstructor
public class GovernorateController {
  
	
	private final GovernorateService gouverneratService;
	 
	
	@PostMapping
	public ResponseEntity<Governorate>saveGouvernerat(@RequestBody Governorate gouvernerat){
		return new ResponseEntity<Governorate>(gouverneratService.saveGovernorate(gouvernerat),HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Governorate>>getAllGouvernerat(){
		return new ResponseEntity<List<Governorate>>(gouverneratService.getAllGovernorates(),HttpStatus.OK);
	}
	//get gouv by code
	@GetMapping("/{codeGouv}")
	public ResponseEntity<Governorate> getGouverneratByCode(@PathVariable String govCode){
		return new ResponseEntity<Governorate>(gouverneratService.getGovernorateByCode(govCode),HttpStatus.OK);
	}
	//update Gouvernerat
	@PutMapping("/{codeGouv}")
	public ResponseEntity<Governorate> updateGouvernerat(@PathVariable String govCode,@RequestBody Governorate gouv){
		return new ResponseEntity<Governorate>(gouverneratService.updateGovernorate(govCode, gouv),HttpStatus.OK);
	}
	
	//getActivate Gouvernerat
	@GetMapping("/Activated")
	public ResponseEntity<List<Governorate>> getActivatedGouvernerat(){
		return new ResponseEntity<List<Governorate>>(gouverneratService.getActivatedGovernorate(),HttpStatus.OK);
	}
	@DeleteMapping("/{govCode}")
	public ResponseEntity<String> deleteGouvernerat(@PathVariable String govCode){
	  gouverneratService.deleteGovernorate(govCode);
	  return new  ResponseEntity<String>("Governorat successfully deleted!", HttpStatus.OK);
	}
	
}
