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

import com.RNE.referentiel.entities.PostalCode;
import com.RNE.referentiel.serviceInterface.PostalCodeService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/referentiel/codePostal")
@AllArgsConstructor
public class PostalCodeController {
  
	private PostalCodeService codePostalService;
	
	@PostMapping
	public ResponseEntity<PostalCode> saveCodePostal(@RequestBody PostalCode codePostal){
		return new ResponseEntity<PostalCode>(codePostalService.savePostalCode(codePostal),HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<PostalCode>> getAllCodesPostal(){
		return new ResponseEntity<List<PostalCode>>(codePostalService.getAllPostalCode(),HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<PostalCode> getCodePostalById(@PathVariable Long id){
		return new ResponseEntity<PostalCode>(codePostalService.getPostalCodeById(id), HttpStatus.OK);
		
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<PostalCode> updateCodePostal(@PathVariable Long id,@RequestBody PostalCode codePostal){
		return new ResponseEntity<PostalCode>(codePostalService.updatePostalCode(id, codePostal),HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteCodePostal(@PathVariable Long id){
		codePostalService.deletePostalCode(id);
		return new  ResponseEntity<String>("PostalCode successfully deleted!", HttpStatus.OK);
	}
}
